package com.anhkiet.cdio4_api.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany


@Entity
class Category {

    @Id
    @Column(
        nullable = false,
        updatable = false
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idcategory: Int? = null

    @Column(name = "\"rank\"")
    var rank: Int? = null

    @Column(length = 50)
    var name: String? = null

    @Column
    var active: Boolean? = null

    @Column(length = 50)
    var state: String? = null

    @OneToMany(mappedBy = "idcategory")
    var idcategoryKeys: MutableSet<Key>? = null

}
