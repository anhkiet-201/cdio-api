package com.anhkiet.cdio4_api.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany


@Entity
class Investor {

    @Id
    @Column(
        nullable = false,
        updatable = false
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idinvestor: Int? = null

    @Column(length = 50)
    var name: String? = null

    @Column(length = 500)
    var logo: String? = null

    @Column(length = 1000)
    var sumary: String? = null

    @Column
    var state: Int? = null

    @OneToMany(mappedBy = "idinvestor")
    var idinvestorDuAns: MutableSet<DuAn>? = null

}
