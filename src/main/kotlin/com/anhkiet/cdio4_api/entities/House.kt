package com.anhkiet.cdio4_api.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import java.math.BigDecimal


@Entity
class House {

    @Id
    @Column(
        nullable = false,
        updatable = false
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var houseId: Int? = null

    @Column
    var displayName: String? = null

    @Column(
        name = "\"description\"",
        columnDefinition = "longtext"
    )
    var description: String? = null

    @Column(
        precision = 12,
        scale = 0
    )
    var createTime: BigDecimal? = null

    @Column(
        nullable = false,
        columnDefinition = "longtext"
    )
    var address: String? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "email_id",
        nullable = false
    )
    var email: Account? = null

    @ManyToMany(mappedBy = "favoriteHouses")
    var favoriteAccounts: MutableSet<Account>? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "project_id",
        nullable = false
    )
    var project: Project? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "category_id",
        nullable = false
    )
    var category: Category? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "infor_id",
        nullable = false
    )
    var infor: HouseInfo? = null

}
