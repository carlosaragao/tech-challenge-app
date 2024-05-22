package br.com.fiap.techfood.app.adapter.output.persistence.entity

import br.com.fiap.techfood.core.domain.enums.OrderStatus
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "TB_ORDERS")
data class OrderEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,

    @Column(nullable = false)
    var name: String? = null,

    @Column(nullable = false)
    private var status: OrderStatus,

    var isAnonymous: Boolean? = null,

    @OneToMany(mappedBy = "id.order")
    var items: List<OrderItemEntity> = listOf(),

    @ManyToOne
    @JoinColumn(name = "client_id", foreignKey = ForeignKey(name = "fk_order_client"))
    var client: ClientEntity? = null,

    @Column(nullable = false)
    var creationDate: LocalDateTime? = null,

    @Column(nullable = false)
    var lastUpdateDate: LocalDateTime? = null
)
