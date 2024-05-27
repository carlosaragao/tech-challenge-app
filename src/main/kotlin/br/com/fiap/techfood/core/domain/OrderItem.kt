package br.com.fiap.techfood.core.domain

import java.util.*

data class OrderItem(
    var quantity: Int? = null,
    var productId: UUID? = null,
    var description: String? = null
)