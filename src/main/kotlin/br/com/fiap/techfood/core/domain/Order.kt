package br.com.fiap.techfood.core.domain

import br.com.fiap.techfood.core.domain.enums.OrderStatusEnum
import java.util.*

data class Order(
    var id: UUID,
    var name: String? = null,
    var items: List<OrderItem>? = null,
    var status: OrderStatusEnum = OrderStatusEnum.AWAITING_PAYMENT,
    var isAnonymous: Boolean? = true,
    var client: Client? = null,
    var timeToPrepare: Int? = null
)