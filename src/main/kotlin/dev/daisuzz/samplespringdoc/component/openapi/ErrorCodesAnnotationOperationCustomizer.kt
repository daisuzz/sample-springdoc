package dev.daisuzz.samplespringdoc.component.openapi

import dev.daisuzz.samplespringdoc.component.annotation.ErrorCodes
import io.swagger.v3.oas.models.Operation
import org.springdoc.core.customizers.OperationCustomizer
import org.springframework.web.method.HandlerMethod

class ErrorCodesAnnotationOperationCustomizer : OperationCustomizer {
    override fun customize(operation: Operation, handlerMethod: HandlerMethod): Operation {
        val annotation = handlerMethod.getMethodAnnotation(ErrorCodes::class.java)
        return if (annotation != null) {
            operation.also {
                it.responses["400"]?.description = annotation.errorCodes.joinToString(",")
            }
        } else {
            operation
        }
    }
}
