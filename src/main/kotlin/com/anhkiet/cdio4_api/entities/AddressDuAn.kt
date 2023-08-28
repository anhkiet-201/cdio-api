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
class AddressDuAn {

    @Id
    @Column(
        nullable = false,
        updatable = false
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idaddressDuAn: Int? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idaddress_id")
    var idaddress: Address? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iddu_an_id")
    var idduAn: DuAn? = null

}
