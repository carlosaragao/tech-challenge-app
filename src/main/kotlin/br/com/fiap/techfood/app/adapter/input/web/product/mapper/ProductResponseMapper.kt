package br.com.fiap.techfood.app.adapter.input.web.product.mapper

import br.com.fiap.techfood.app.adapter.input.web.product.dto.ProductRequest
import br.com.fiap.techfood.app.adapter.input.web.product.dto.ProductResponse
import br.com.fiap.techfood.core.domain.Product
import br.com.fiap.techfood.core.domain.enums.CategoryEnum
import br.com.fiap.techfood.core.domain.vo.ProductVO
import java.util.*

fun Product.toProductResponse(): ProductResponse =
    ProductResponse(
        name = this.name,
        description = this.description,
        price = this.price,
        category = CategoryEnum.toEnum(this.category),
        imageURL = this.imageURL
    )

fun ProductVO.toProductResponse(): ProductResponse =
    ProductResponse(
        name,
        description,
        price,
        CategoryEnum.toEnum(this.category),
        imageURL,
    )

fun ProductRequest.toDomain(): Product =
    Product(
        id = UUID.randomUUID(),
        name = this.name,
        description = this.description,
        price = this.price,
        category = this.category.id,
        imageURL = this.imageURL
    )



