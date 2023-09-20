package com.anhkiet.cdio4_api.entities

import jakarta.persistence.*

@Entity
class Address {

    @Id
    @Column(
        nullable = false,
        updatable = false
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = -1

    @Column(length = 100)
    var province: String = ""

    @Column(length = 100)
    var district: String = ""

    @Column(length = 100)
    var wards: String = ""

    @Column(length = 100)
    var street: String = ""

    @Column(
        name = "\"description\"",
        columnDefinition = "longtext"
    )
    var description: String? = null

    @OneToMany(mappedBy = "address")
    var addressHouses: MutableSet<House>? = null

}