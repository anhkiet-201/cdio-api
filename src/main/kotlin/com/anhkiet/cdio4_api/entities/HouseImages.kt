package com.anhkiet.cdio4_api.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany


@Entity
class HouseImages {

    @Id
    @Column(
        nullable = false,
        updatable = false
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var houseImageId: Int = 0

    @Column(columnDefinition = "longtext")
    var imageUrl: String = ""

    @OneToMany(mappedBy = "houseImage")
    var houseImageHouseInfos: MutableSet<HouseInfo>? = null

}
