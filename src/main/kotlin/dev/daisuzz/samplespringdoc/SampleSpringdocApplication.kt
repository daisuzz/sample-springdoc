package dev.daisuzz.samplespringdoc

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@OpenAPIDefinition(info = Info(title = "サンプルECサイトAPIドキュメント", description = "サンプルECサイトWebアプリケーション用のAPIドキュメント"))
class SampleSpringdocApplication

fun main(args: Array<String>) {
    runApplication<SampleSpringdocApplication>(*args)
}
