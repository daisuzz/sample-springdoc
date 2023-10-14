package dev.daisuzz.samplespringdoc.presentation.cart

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("carts")
@Suppress("MagicNumber", "UnusedParameter")
@Tag(name = "カートAPI", description = "カートに関する操作を行うAPI")
class CartController {

    @GetMapping
    @Operation(summary = "カート一覧取得API", description = "カート一覧取得API")
    fun getCarts(): List<CartResponse> {
        return listOf(
            CartResponse(
                cartId = "1",
                itemList = listOf(
                    ItemResponse(
                        itemId = "1",
                        name = "MacBook Air",
                        price = 150000,
                    ),
                    ItemResponse(
                        itemId = "2",
                        name = "MacBook Pro",
                        price = 300000,
                    ),
                )
            ),
            CartResponse(
                cartId = "2",
                itemList = listOf(
                    ItemResponse(
                        itemId = "1",
                        name = "MacBook Air",
                        price = 150000,
                    ),
                    ItemResponse(
                        itemId = "3",
                        name = "ChromeBook",
                        price = 100000,
                    ),
                )
            ),
        )
    }

    @GetMapping("{cartId}")
    @Operation(summary = "カート取得API", description = "カート取得API")
    fun getCart(@PathVariable cartId: String): CartResponse {
        return CartResponse(
            cartId = "1",
            itemList = listOf(
                ItemResponse(
                    itemId = "1",
                    name = "MacBook Air",
                    price = 150000,
                ),
                ItemResponse(
                    itemId = "2",
                    name = "MacBook Pro",
                    price = 300000,
                ),
            )
        )
    }
}
