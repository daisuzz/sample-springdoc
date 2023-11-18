package dev.daisuzz.samplespringdoc.configuration

import dev.daisuzz.samplespringdoc.component.openapi.ErrorResponseOpenApiCustomizer
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfiguration {

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
        return ErrorResponseOpenApiCustomizer()
    }
}
