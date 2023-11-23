package dev.daisuzz.samplespringdoc.component.openapi

import dev.daisuzz.samplespringdoc.component.error.ClientErrorResponse
import dev.daisuzz.samplespringdoc.component.error.SystemErrorResponse
import dev.daisuzz.samplespringdoc.component.openapi.annotation.ErrorCodes
import io.swagger.v3.core.converter.ModelConverters
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.media.Content
import io.swagger.v3.oas.models.media.MediaType
import io.swagger.v3.oas.models.media.Schema
import io.swagger.v3.oas.models.responses.ApiResponse
import org.springdoc.core.customizers.OpenApiCustomizer
import org.springframework.web.method.HandlerMethod
import java.util.concurrent.ConcurrentHashMap

class ErrorResponseOpenApiCustomizer(private val operationHandlerMethods: ConcurrentHashMap<String, HandlerMethod>) :
    OpenApiCustomizer {
    override fun customise(openApi: OpenAPI) {
        // componentsにErrorResponseのSchemaを追加
        openApi.components.schemas.putAll(ModelConverters.getInstance().read(ClientErrorResponse::class.java))
        openApi.components.schemas.putAll(ModelConverters.getInstance().read(SystemErrorResponse::class.java))

        // 各エンドポイントのoperationにErrorResponseへのrefを追加
        val clientErrorResponse = buildErrorResponse<ClientErrorResponse>("クライアントエラー")
        val systemErrorResponse = buildErrorResponse<SystemErrorResponse>("システムエラー")
        openApi.paths.values
            .flatMap { it.readOperations() }
            .map { operation ->
                val annotation =
                    operationHandlerMethods[operation.operationId]?.getMethodAnnotation(ErrorCodes::class.java)
                val errorCodes = annotation
                    ?.errorCodes
                    ?.joinToString(",") { it }
                    ?: ""
                clientErrorResponse.description = "${clientErrorResponse.description}$errorCodes"
                operation.responses
                    .addApiResponse("4xx", clientErrorResponse)
                    .addApiResponse("5xx", systemErrorResponse)
            }
    }

    private inline fun <reified T> buildErrorResponse(description: String): ApiResponse {
        return ApiResponse()
            .description(description)
            .content(
                Content()
                    .addMediaType(
                        "application/json",
                        MediaType()
                            .schema(
                                Schema<T>()
                                    .`$ref`("#/components/schemas/${T::class.simpleName}")
                            )
                    )
            )
    }
}
