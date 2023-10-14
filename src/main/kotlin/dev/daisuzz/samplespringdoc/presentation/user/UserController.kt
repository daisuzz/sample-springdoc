package dev.daisuzz.samplespringdoc.presentation.user

import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("users")
@Suppress("MagicNumber", "UnusedParameter")
class UserController {

    @GetMapping
    @Operation(summary = "ユーザ一覧取得API", description = "ユーザ一覧取得API")
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
    @Operation(summary = "ユーザ取得API", description = "ユーザ取得API")
    fun getUser(@PathVariable userId: String): UserResponse {
        return UserResponse("1", "Alice", 20)
    }
}
