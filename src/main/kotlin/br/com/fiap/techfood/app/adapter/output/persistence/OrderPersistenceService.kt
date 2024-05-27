package br.com.fiap.techfood.app.adapter.output.persistence

import br.com.fiap.techfood.app.adapter.output.persistence.mapper.toDomain
import br.com.fiap.techfood.app.adapter.output.persistence.mapper.toEntity
import br.com.fiap.techfood.app.adapter.output.persistence.repository.ClientRepository
import br.com.fiap.techfood.app.adapter.output.persistence.repository.OrderRepository
import br.com.fiap.techfood.core.common.annotation.PersistenceAdapter
import br.com.fiap.techfood.core.domain.Client
import br.com.fiap.techfood.core.domain.Order
import br.com.fiap.techfood.core.domain.enums.OrderStatusEnum
import br.com.fiap.techfood.core.port.output.OrderOutputPort
import java.util.*

@PersistenceAdapter
class OrderPersistenceService(
    private val orderRepository: OrderRepository,
    private val clientRepository: ClientRepository,
) : OrderOutputPort {

    override fun save(order: Order): Order {
        val orderEntity = order.toEntity()
        val savedEntity = orderRepository.save(orderEntity)
        return savedEntity.toDomain()
    }

    override fun findClientByCpf(cpf: String): Client? {
        val clientEntity = clientRepository.findByCpf(cpf)
        return clientEntity?.toDomain()
    }

    override fun findAllByStatus(status: OrderStatusEnum): List<Order> {
        return orderRepository.findAllByStatus(status).map { it.toDomain() }
    }

    override fun deleteById(id: UUID) {
        orderRepository.deleteById(id)
    }

    override fun findById(id: UUID): Order {
        return orderRepository.findById(id).orElseThrow { Exception("Order not found") }.toDomain()
    }
}