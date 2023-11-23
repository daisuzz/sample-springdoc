package dev.daisuzz.samplespringdoc.component.openapi

import io.swagger.v3.core.converter.AnnotatedType
import io.swagger.v3.oas.models.media.Schema
import org.hibernate.validator.constraints.CodePointLength
import org.springdoc.core.customizers.PropertyCustomizer

class CustomAnnotationPropertyCustomizer : PropertyCustomizer {
    override fun customize(property: Schema<*>, type: AnnotatedType): Schema<*> {
        val annotations: Map<String?, Annotation> = type.ctxAnnotations
            ?.associateBy { it.annotationClass.simpleName }
            ?: emptyMap()

        if (annotations.containsKey(CodePointLength::class.java.simpleName)) {
            val anno = annotations[CodePointLength::class.java.simpleName] as CodePointLength
            property.minLength = anno.min
            property.maxLength = anno.max
        }

        return property
    }
}
