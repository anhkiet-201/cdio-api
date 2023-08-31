package com.anhkiet.cdio4_api.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.math.BigDecimal


@Entity
class News {

    @Id
    @Column(
        nullable = false,
        updatable = false
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var newsId: Int? = null

    @Column(
        precision = 12,
        scale = 0
    )
    var createTime: BigDecimal? = null

    @Column(nullable = false)
    var title: String? = null

    @Column(
        nullable = false,
        columnDefinition = "longtext"
    )
    var content: String? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "email",
        nullable = false
    )
    var account: Account? = null

}
