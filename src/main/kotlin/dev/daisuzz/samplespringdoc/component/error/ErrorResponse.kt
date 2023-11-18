package dev.daisuzz.samplespringdoc.component.error

import io.swagger.v3.oas.annotations.media.Schema

data class ErrorResponse(
    @Schema(description = "エラーメッセージ", example = "入力エラー")
    val message: String,

    @Schema(description = "エラーコード", example = "ERROR_00001")
    val errorCode: String,
)
