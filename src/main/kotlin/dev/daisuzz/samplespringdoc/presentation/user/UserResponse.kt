package dev.daisuzz.samplespringdoc.presentation.user

import io.swagger.v3.oas.annotations.media.Schema

data class UserResponse(
    @Schema(description = "ユーザID", example = "1")
    val userId: String,
    @Schema(description = "名前", example = "山田太郎")
    val name: String,
    @Schema(description = "年齢", example = "30")
    val age: Int,
)
