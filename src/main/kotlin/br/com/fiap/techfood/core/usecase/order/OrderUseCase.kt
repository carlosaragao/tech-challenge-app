package br.com.fiap.techfood.core.usecase.order

import br.com.fiap.techfood.core.common.annotation.UseCase
import br.com.fiap.techfood.core.domain.DomainOrderRequest
import br.com.fiap.techfood.core.domain.Order
import br.com.fiap.techfood.core.domain.enums.OrderStatusEnum
import br.com.fiap.techfood.core.port.input.OrderInputPort
import br.com.fiap.techfood.core.port.output.OrderOutputPort
import java.util.*

@UseCase
class OrderUseCase(
    private val orderOutput: OrderOutputPort
) : OrderInputPort {

    override fun save(orderRequest: DomainOrderRequest): Order {
        val client = orderRequest.clientCpf?.let {
            if (it.isNotBlank()) orderOutput.findClientByCpf(it) else null
        }

        val order = Order(
            id = UUID.randomUUID(),
            name = orderRequest.orderName,
            items = orderRequest.orderItems,
            status = OrderStatusEnum.AWAITING_PAYMENT,
            isAnonymous = client == null,
            client = client,
            timeToPrepare = 0
        )

        return orderOutput.save(order)
    }


    override fun findAllAwaitingPayment(): List<Order> {
        return orderOutput.findAllByStatus(OrderStatusEnum.AWAITING_PAYMENT)
    }

    override fun findAllApprovedOrders(): List<Order> {
        return orderOutput.findAllByStatus(OrderStatusEnum.PAYMENT_APPROVED)
    }

    override fun findAllPreparedOrders(): List<Order> {
        return orderOutput.findAllByStatus(OrderStatusEnum.PREPARED)
    }

    override fun findAllFinishedOrders(): List<Order> {
        return orderOutput.findAllByStatus(OrderStatusEnum.FINISHED)
    }

    override fun deleteOrder(id: UUID) {
        orderOutput.deleteById(id)
    }

    override fun approvePayment(id: UUID) {
        val order = orderOutput.findById(id)
        order.status = OrderStatusEnum.PAYMENT_APPROVED
        orderOutput.save(order)
    }

    override fun prepareOrder(id: UUID) {
        val order = orderOutput.findById(id)
        order.status = OrderStatusEnum.PREPARED
        order.timeToPrepare = calculateTimeToPrepare(order)
        orderOutput.save(order)
    }

    fun calculateTimeToPrepare(order: Order): Int {
        return 15 // 15 minutos por pedido
    }

    override fun finishOrder(id: UUID) {
        val order = orderOutput.findById(id)
        order.status = OrderStatusEnum.FINISHED
        orderOutput.save(order)
    }
}