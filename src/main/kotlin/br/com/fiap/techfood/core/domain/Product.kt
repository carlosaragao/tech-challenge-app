package br.com.fiap.techfood.core.domain

import java.math.BigDecimal
import java.util.*

data class Product(
    var id: UUID? = null,
    var name: String?,
    var description: String?,
    var price: BigDecimal?,
    var category: Int?,
    var imageURL: String?,
)