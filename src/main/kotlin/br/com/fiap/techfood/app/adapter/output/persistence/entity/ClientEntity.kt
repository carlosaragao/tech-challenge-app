package br.com.fiap.techfood.app.adapter.output.persistence.entity

import br.com.fiap.techfood.core.common.annotation.NoArgsConstructor
import jakarta.persistence.*
import java.util.*

@Entity
@NoArgsConstructor
@Table(name = "TB_CLIENTS")
data class ClientEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null,

    @Column(nullable = false, unique = true)
    var cpf: String,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false, unique = true)
    var email: String,

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    var orders: List<OrderEntity> = listOf()
)
