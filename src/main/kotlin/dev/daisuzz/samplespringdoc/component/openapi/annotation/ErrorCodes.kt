package dev.daisuzz.samplespringdoc.component.openapi.annotation

@Target(AnnotationTarget.FUNCTION)
annotation class ErrorCodes(val errorCodes: Array<String>)
