package com.anhkiet.cdio4_api.entities

import jakarta.persistence.*
import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType


@Entity
class HouseImages {

    @Id
    @Column(
        nullable = false,
        updatable = false
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var houseImageId: Int? = null

    @Column(columnDefinition = "longtext")
    var imageUrl: String = ""

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "infor_id",
        nullable = false
    )
    @Cascade(CascadeType.ALL)
    var houseImageHouseInfos: HouseInfo? = null

}
