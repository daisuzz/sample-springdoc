package dev.daisuzz.samplespringdoc.component.openapi

import io.swagger.v3.oas.models.parameters.Parameter
import org.hibernate.validator.constraints.CodePointLength
import org.springdoc.core.customizers.ParameterCustomizer
import org.springframework.core.MethodParameter

class CustomAnnotationParameterCustomizer : ParameterCustomizer {
    override fun customize(parameterModel: Parameter?, methodParameter: MethodParameter?): Parameter? {
        val annotations: Map<String?, Annotation> = methodParameter
            ?.parameterAnnotations
            ?.associateBy { it.annotationClass.simpleName }
            ?: emptyMap()

        if (annotations.containsKey(CodePointLength::class.java.simpleName)) {
            val anno = annotations[CodePointLength::class.java.simpleName] as CodePointLength
            parameterModel?.schema?.minLength = anno.min
            parameterModel?.schema?.maxLength = anno.max
        }

        return parameterModel
    }
}
