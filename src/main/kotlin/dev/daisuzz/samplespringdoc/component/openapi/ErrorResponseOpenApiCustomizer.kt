package dev.daisuzz.samplespringdoc.component.openapi

import dev.daisuzz.samplespringdoc.component.error.ErrorResponse
import io.swagger.v3.core.converter.ModelConverters
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.media.Content
import io.swagger.v3.oas.models.media.MediaType
import io.swagger.v3.oas.models.media.Schema
import io.swagger.v3.oas.models.responses.ApiResponse
import org.springdoc.core.customizers.OpenApiCustomizer

class ErrorResponseOpenApiCustomizer : OpenApiCustomizer {
    override fun customise(openApi: OpenAPI) {
        // componentsにErrorResponseのSchemaを追加
        openApi.components.schemas.putAll(ModelConverters.getInstance().read(ErrorResponse::class.java))

        // 各エンドポイントのoperationにErrorResponseへのrefを追加
        val errorResponse = buildErrorResponse()
        openApi.paths.values
            .flatMap { it.readOperations() }
            .map { it.responses.addApiResponse("400", errorResponse) }
    }

    private fun buildErrorResponse(): ApiResponse {
        return ApiResponse()
            .description("エラーレスポンス")
            .content(
                Content()
                    .addMediaType(
                        "application/json",
                        MediaType()
                            .schema(
                                Schema<ErrorResponse>()
                                    .`$ref`("#/components/schemas/${ErrorResponse::class.simpleName}")
                            )
                    )
            )
    }
}
