package com.anhkiet.cdio4_api.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import java.math.BigDecimal


@Entity
class HouseType {

    @Id
    @Column(
        nullable = false,
        updatable = false
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var houseTypeId: Int? = null

    @Column(length = 50)
    var typeName: String? = null

    @Column(
        precision = 20,
        scale = 5
    )
    var price: BigDecimal? = null

    @ManyToMany(mappedBy = "houseTypeDetailHouseTypes")
    var houseTypeDetailHouseInfos: MutableSet<HouseInfo>? = null

}
