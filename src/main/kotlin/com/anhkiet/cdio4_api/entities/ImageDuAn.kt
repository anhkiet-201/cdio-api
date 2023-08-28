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
class ImageDuAn {

    @Id
    @Column(
        nullable = false,
        updatable = false
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idimageDuAn: Int? = null

    @Column(length = 500)
    var link: String? = null

    @Column(name = "\"rank\"")
    var rank: Int? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iddu_an_id")
    var idduAn: DuAn? = null

}
