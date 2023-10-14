package dev.daisuzz.samplespringdoc.presentation.user

import jakarta.validation.constraints.Min

data class UserRequest(
    val name: String,

    @field:Min(0)
    val age: Int,
)
