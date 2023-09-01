package com.anhkiet.cdio4_api.entities

import jakarta.persistence.*


@Entity
class HouseInfo {

    @Id
    @Column(
        nullable = false,
        updatable = false
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var inforId: Int = -1

    @Column
    var thumbNailUrl: String? = null

    @Column(nullable = false)
    var numKitchen: Int? = null

    @Column(nullable = false)
    var numBathroom: Int? = null

    @Column(nullable = false)
    var numToilet: Int? = null

    @Column(nullable = false)
    var numLivingRoom: Int? = null

    @Column(nullable = false)
    var numBedRoom: Int? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "house_image_id",
        nullable = false
    )
    var houseImage: HouseImages? = null

    @ManyToMany
    @JoinTable(
        name = "house_type_detail",
        joinColumns = [
            JoinColumn(name = "infor_id")
        ],
        inverseJoinColumns = [
            JoinColumn(name = "house_type_id")
        ]
    )
    var houseTypeDetailHouseTypes: MutableSet<HouseType>? = null

}
