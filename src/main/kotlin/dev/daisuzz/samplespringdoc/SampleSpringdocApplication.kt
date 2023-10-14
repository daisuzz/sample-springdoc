package dev.daisuzz.samplespringdoc

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@OpenAPIDefinition(
    info = Info(
        title = "サンプルECサイトAPIドキュメント",
        description = "サンプルECサイトWebアプリケーション用のAPIドキュメント",
        version = "1.0.0"
    )
)
class SampleSpringdocApplication

fun main(args: Array<String>) {
    runApplication<SampleSpringdocApplication>(*args)
}
