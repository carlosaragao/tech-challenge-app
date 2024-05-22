package br.com.fiap.techfood.app.adapter.output.persistence.entity

import jakarta.persistence.Column
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "TB_ORDER_ITEMS")
class OrderItemEntity (

    @EmbeddedId
    var id: OrderItemPk = OrderItemPk(),

    @Column(nullable = false)
    var quantity: Int? = null,

    var description: String? = null
)
