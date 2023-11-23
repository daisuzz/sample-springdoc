package dev.daisuzz.samplespringdoc.component.openapi

import io.swagger.v3.oas.models.Operation
import org.springdoc.core.customizers.OperationCustomizer
import org.springframework.web.method.HandlerMethod
import java.util.concurrent.ConcurrentHashMap

class OperationHandlerMethodOperationCustomizer(private val operationHandlerMethods: ConcurrentHashMap<String, HandlerMethod>) :
    OperationCustomizer {
    override fun customize(operation: Operation, handlerMethod: HandlerMethod): Operation {
        operationHandlerMethods[operation.operationId] = handlerMethod
        return operation
    }
}
