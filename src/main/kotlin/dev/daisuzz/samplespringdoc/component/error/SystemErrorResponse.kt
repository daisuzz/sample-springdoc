package dev.daisuzz.samplespringdoc.component.error

import io.swagger.v3.oas.annotations.media.Schema

data class SystemErrorResponse(
    @Schema(description = "エラーメッセージ", example = "システムエラー")
    val message: String,

    @Schema(description = "エラーコード", example = "ERROR_00002")
    val errorCode: String,
)
