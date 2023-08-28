package com.anhkiet.cdio4_api.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne


@Entity
class InfoHouse {

    @Id
    @Column(
        nullable = false,
        updatable = false
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idinfoHouse: Int? = null

    @Column(length = 500)
    var `value`: String? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idhouse_id")
    var idhouse: House? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idkey_id")
    var idkey: Key? = null

}
