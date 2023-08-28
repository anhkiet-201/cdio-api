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
import jakarta.persistence.Table


@Entity
@Table(name = "\"key\"")
class Key {

    @Id
    @Column(
        nullable = false,
        updatable = false
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idkey: Int? = null

    @Column(length = 50)
    var name: String? = null

    @Column(name = "\"rank\"")
    var rank: Int? = null

    @Column
    var active: Boolean? = null

    @Column
    var required: Boolean? = null

    @Column(length = 50)
    var type: String? = null

    @OneToMany(mappedBy = "idkey")
    var idkeyInfoDuAns: MutableSet<InfoDuAn>? = null

    @OneToMany(mappedBy = "idkey")
    var idkeyInfoHouses: MutableSet<InfoHouse>? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcategory_id")
    var idcategory: Category? = null

}
