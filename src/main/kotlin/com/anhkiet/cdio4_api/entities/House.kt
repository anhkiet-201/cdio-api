package com.anhkiet.cdio4_api.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import java.math.BigDecimal
import java.time.OffsetDateTime


@Entity
class House {

    @Id
    @Column(
        nullable = false,
        updatable = false
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var createBy: Int? = null

    @Column(nullable = false)
    var idhouse: Int? = null

    @Column(length = 50)
    var code: String? = null

    @Column(length = 100)
    var name: String? = null

    @Column(length = 3000)
    var sumary: String? = null

    @Column
    var views: Int? = null

    @Column(length = 50)
    var type: String? = null

    @Column(length = 50)
    var idmap: String? = null

    @Column
    var bedRoom: Int? = null

    @Column
    var area: Int? = null

    @Column(
        precision = 30,
        scale = 0
    )
    var price: BigDecimal? = null

    @Column
    var state: Int? = null

    @Column
    var createTime: OffsetDateTime? = null

    @OneToMany(mappedBy = "idhouse")
    var idhouseAddressHouses: MutableSet<AddressHouse>? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iddu_an_id")
    var idduAn: DuAn? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idtai_khoan_id")
    var idtaiKhoan: TaiKhoan? = null

    @OneToMany(mappedBy = "idhouse")
    var idhouseImageHouses: MutableSet<ImageHouse>? = null

    @OneToMany(mappedBy = "idhouse")
    var idhouseInfoHouses: MutableSet<InfoHouse>? = null

}
