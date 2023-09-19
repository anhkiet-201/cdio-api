package com.anhkiet.cdio4_api.entities

import jakarta.persistence.*
import java.math.BigDecimal


@Entity
class House {

    @Id
    @Column(
        nullable = false,
        updatable = false
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var houseId: Int = -1

    @Column
    var displayName: String = ""

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
        name = "id",
        nullable = false
    )
    var address: Address? = null

    @OneToOne
    @JoinColumn(
        name = "infor_id",
        nullable = false
    )
    var infor: HouseInfo? = null

}
