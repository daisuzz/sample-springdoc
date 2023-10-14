package dev.daisuzz.samplespringdoc.presentation.item

import dev.daisuzz.samplespringdoc.presentation.cart.ItemResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("items")
@Suppress("MagicNumber", "UnusedParameter")
@Tag(name = "商品API", description = "商品に関する操作を行うAPI")
class ItemController {

    @GetMapping
    @Operation(summary = "商品一覧取得API", description = "商品一覧取得API")
    fun getItems(): List<ItemResponse> {
        return listOf(
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
    }

    @Operation(summary = "商品取得API", description = "商品取得API")
    @GetMapping("{itemId}")
    fun getItem(@PathVariable itemId: String): ItemResponse {
        return ItemResponse(
            itemId = "1",
            name = "MacBook Air",
            price = 150000,
        )
    }
}
