package dev.daisuzz.samplespringdoc.component.annotation

@Target(AnnotationTarget.FUNCTION)
annotation class ErrorCodes(val errorCodes: Array<String>)
