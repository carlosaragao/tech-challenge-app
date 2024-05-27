package br.com.fiap.techfood.core.domain.vo

import java.math.BigDecimal

data class ProductVO (
    var name: String?,
    var description: String?,
    var price: BigDecimal?,
    var category: Int?,
    var imageURL: String?,
)