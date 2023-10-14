package dev.daisuzz.samplespringdoc.presentation.cart

data class CartResponse(
    val cartId: String,
    val itemList: List<ItemResponse>
)

data class ItemResponse(
    val itemId: String,
    val name: String,
    val price: Int,
)
