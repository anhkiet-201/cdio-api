package com.anhkiet.cdio4_api.entities

import jakarta.persistence.*


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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "infor_id",
        nullable = false
    )
    var houseImageHouseInfos: HouseInfo? = null

}
