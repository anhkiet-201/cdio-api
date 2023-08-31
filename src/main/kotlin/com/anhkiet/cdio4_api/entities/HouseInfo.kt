package com.anhkiet.cdio4_api.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany


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

    @OneToMany(mappedBy = "infor")
    var inforHouses: MutableSet<House>? = null

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
