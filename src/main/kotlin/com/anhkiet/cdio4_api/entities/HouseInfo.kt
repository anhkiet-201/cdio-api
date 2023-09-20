package com.anhkiet.cdio4_api.entities

import jakarta.persistence.*
import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType


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

    @OneToMany(mappedBy = "houseImageHouseInfos")
    var houseImage: MutableSet<HouseImages>? = null

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
    @Cascade(CascadeType.ALL)
    var houseTypeDetailHouseTypes: MutableSet<HouseType>? = null

}
