package br.com.fiap.techfood.app.adapter.output.persistence.entity

import br.com.fiap.techfood.core.domain.enums.CategoryEnum
import jakarta.persistence.*
import java.math.BigDecimal
import java.util.*

@Entity
@Table(name = "TB_PRODUCTS")
class ProductEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null,

    @Column(nullable = false)
    var name: String? = null,

    @Column(nullable = false)
    var description: String? = null,

    @Column(nullable = false)
    var price: BigDecimal? = null,

    @Column(nullable = false)
    var category: CategoryEnum,

    @Column(nullable = false)
    var imageURL: String? = null
)