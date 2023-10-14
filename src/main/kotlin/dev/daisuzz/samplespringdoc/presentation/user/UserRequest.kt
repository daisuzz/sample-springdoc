package dev.daisuzz.samplespringdoc.presentation.user

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotEmpty

data class UserRequest(
    @Schema(description = "名前", example = "山田太郎")
    @field:NotEmpty
    val name: String,

    @Schema(description = "年齢", example = "30")
    @field:Min(0)
    val age: Int,
)
