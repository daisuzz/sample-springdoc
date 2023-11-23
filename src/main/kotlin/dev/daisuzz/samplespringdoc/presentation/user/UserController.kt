package dev.daisuzz.samplespringdoc.presentation.user

import dev.daisuzz.samplespringdoc.component.openapi.annotation.ErrorCodes
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.hibernate.validator.constraints.CodePointLength
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("users")
@Suppress("MagicNumber", "UnusedParameter")
@Tag(name = "ユーザAPI", description = "ユーザに関する操作を行うAPI")
class UserController {

    @GetMapping
    @Operation(
        summary = "ユーザ一覧取得API",
        description = "全ユーザを取得する。",
    )
    @ErrorCodes(["ERROR_00001", "ERROR_00002", "ERROR_00003"])
    fun getUsers(): List<UserResponse> {
        return listOf(
            UserResponse(
                "1",
                "Alice",
                20,
            ),
            UserResponse(
                "2",
                "Bob",
                30
            )
        )
    }

    @GetMapping("{userId}")
    @Operation(
        summary = "ユーザ取得API",
        description = "指定されたユーザIDに紐づくユーザを取得する。",
    )
    fun getUser(
        @Parameter(description = "ユーザID")
        @PathVariable
        @CodePointLength(min = 0, max = 10) userId: String
    ): UserResponse {
        return UserResponse("1", "Alice", 20)
    }

    @PostMapping
    @Operation(
        summary = "ユーザ登録API",
        description = "ユーザを登録する。",
    )
    fun createUser(@Valid @RequestBody userRequest: UserRequest): ResponseEntity<String> {
        return ResponseEntity.ok().build()
    }

    @DeleteMapping("{userId}")
    @Operation(
        summary = "ユーザ削除API",
        description = "指定されたユーザIDを削除する。",
    )
    fun deleteUser(@Parameter(description = "ユーザID") @PathVariable userId: String): ResponseEntity<String> {
        return ResponseEntity.ok().build()
    }
}
