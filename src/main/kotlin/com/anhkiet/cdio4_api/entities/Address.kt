package com.anhkiet.cdio4_api.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany


@Entity
class Address {

    @Id
    @Column(
        nullable = false,
        updatable = false
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idaddress: Int? = null

    @Column(length = 50)
    var name: String? = null

    @Column(length = 50)
    var type: String? = null

    @Column(name = "\"rank\"")
    var rank: Int? = null

    @Column
    var active: Boolean? = null

    @OneToMany(mappedBy = "idaddress")
    var idaddressAddressDuAns: MutableSet<AddressDuAn>? = null

    @OneToMany(mappedBy = "idaddress")
    var idaddressAddressHouses: MutableSet<AddressHouse>? = null

}
