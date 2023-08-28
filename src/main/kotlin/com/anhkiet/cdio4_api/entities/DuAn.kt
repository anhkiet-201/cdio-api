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
import java.time.LocalDate


@Entity
class DuAn {

    @Id
    @Column(
        nullable = false,
        updatable = false
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idduAn: Int? = null

    @Column
    var block: Int? = null

    @Column
    var floor: Int? = null

    @Column
    var house: Int? = null

    @Column(length = 3000)
    var sumary: String? = null

    @Column(length = 50)
    var idmap: String? = null

    @Column
    var state: Int? = null

    @Column(length = 100)
    var name: String? = null

    @Column
    var start: LocalDate? = null

    @Column(length = 50)
    var giaBan: String? = null

    @Column(length = 50)
    var giaThue: String? = null

    @OneToMany(mappedBy = "idduAn")
    var idduAnAddressDuAns: MutableSet<AddressDuAn>? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idinvestor_id")
    var idinvestor: Investor? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idtai_khoan_id")
    var idtaiKhoan: TaiKhoan? = null

    @OneToMany(mappedBy = "idduAn")
    var idduAnHouses: MutableSet<House>? = null

    @OneToMany(mappedBy = "idduAn")
    var idduAnImageDuAns: MutableSet<ImageDuAn>? = null

    @OneToMany(mappedBy = "idduAn")
    var idduAnInfoDuAns: MutableSet<InfoDuAn>? = null

}
