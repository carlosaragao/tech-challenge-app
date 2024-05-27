package br.com.fiap.techfood.app.adapter.output.persistence.mapper

import br.com.fiap.techfood.app.adapter.output.persistence.entity.OrderEntity
import br.com.fiap.techfood.app.adapter.output.persistence.entity.OrderItemEntity
import br.com.fiap.techfood.app.adapter.output.persistence.entity.OrderItemPk
import br.com.fiap.techfood.app.adapter.output.persistence.entity.ProductEntity
import br.com.fiap.techfood.core.domain.Order
import br.com.fiap.techfood.core.domain.OrderItem
import java.time.LocalDateTime

fun Order.toEntity(): OrderEntity {
    val orderEntity = OrderEntity(
        id = this.id,
        name = this.name,
        status = this.status,
        isAnonymous = this.isAnonymous,
        client = this.client?.toEntity(),
        creationDate = LocalDateTime.now(),
        lastUpdateDate = LocalDateTime.now()
    )
    orderEntity.items = this.items?.map { it.toEntity(orderEntity) } ?: listOf()
    return orderEntity
}

fun OrderItem.toEntity(orderEntity: OrderEntity): OrderItemEntity {
    return OrderItemEntity(
        id = OrderItemPk(
            order = orderEntity,
            product = ProductEntity(id = this.productId) // Assuming you have a minimal ProductEntity with just the ID
        ),
        quantity = this.quantity,
        description = this.description
    )
}

fun OrderEntity.toDomain(): Order {
    return Order(
        id = this.id!!,
        name = this.name,
        status = this.status,
        isAnonymous = this.isAnonymous,
        client = this.client?.toDomain(),
        items = this.items.map { it.toDomain() }
    )
}

fun OrderItemEntity.toDomain(): OrderItem {
    return OrderItem(
        quantity = this.quantity,
        productId = this.id.product?.id,
        description = this.description
    )
}
