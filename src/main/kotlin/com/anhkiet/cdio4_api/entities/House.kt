package com.anhkiet.cdio4_api.entities

import jakarta.persistence.*
import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
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
        precision = 18,
        scale = 0
    )
    var createTime: BigDecimal? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "email_id",
        nullable = false
    )
    @Cascade(CascadeType.ALL)
    var email: Account? = null

    @ManyToMany(mappedBy = "favoriteHouses")
    @Cascade(CascadeType.ALL)
    var favoriteAccounts: MutableSet<Account>? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "project_id",
        nullable = false
    )
    @Cascade(CascadeType.ALL)
    var project: Project? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "id",
        nullable = false
    )
    @Cascade(CascadeType.ALL)
    var address: Address? = null

    @OneToOne
    @JoinColumn(
        name = "infor_id",
        nullable = false
    )
    @Cascade(CascadeType.ALL)
    var infor: HouseInfo? = null

}
