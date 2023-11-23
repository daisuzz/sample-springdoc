package dev.daisuzz.samplespringdoc.configuration

import dev.daisuzz.samplespringdoc.component.openapi.ErrorResponseOpenApiCustomizer
import dev.daisuzz.samplespringdoc.component.openapi.OperationHandlerMethodOperationCustomizer
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springdoc.core.customizers.OperationCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.method.HandlerMethod
import java.util.concurrent.ConcurrentHashMap

@Configuration
class OpenApiConfiguration {

    private val operationHandlerMethods = ConcurrentHashMap<String, HandlerMethod>()

    @Bean
    fun openApi(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("サンプルECサイトAPIドキュメント")
                    .description("サンプルECサイトWebアプリケーション用のAPIドキュメント")
                    .version("1.0.0")
            )
    }

    @Bean
    fun errorResponseOpenApiCustomizer(): ErrorResponseOpenApiCustomizer {
        return ErrorResponseOpenApiCustomizer(operationHandlerMethods)
    }

    @Bean
    fun operationHandlerMethodOperationCustomizer(): OperationCustomizer {
        return OperationHandlerMethodOperationCustomizer(operationHandlerMethods)
    }
}
