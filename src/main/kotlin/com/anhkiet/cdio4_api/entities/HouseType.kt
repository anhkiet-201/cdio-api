package com.anhkiet.cdio4_api.entities

import jakarta.persistence.*
import java.math.BigDecimal


@Entity
class HouseType {

    @Id
    @Column(
        nullable = false,
        updatable = false
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var houseTypeId: Int = -1

    @Column(length = 50)
    var typeName: String = ""

    @Column(
        precision = 20,
        scale = 5
    )
    var price: BigDecimal = BigDecimal(0)

    @ManyToMany(mappedBy = "houseTypeDetailHouseTypes")
    var houseTypeDetailHouseInfos: MutableSet<HouseInfo>? = null

}
