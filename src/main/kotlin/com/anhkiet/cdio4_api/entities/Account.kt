package com.anhkiet.cdio4_api.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.OneToMany
import java.math.BigDecimal


@Entity
class Account {

    @Id
    @Column(
        nullable = false,
        updatable = false,
        length = 50
    )
    var email: String? = null

    @Column(
        nullable = false,
    )
    var password: String? = null

    @Column
    var avatarUrl: String? = null

    @Column(length = 50)
    var fullName: String? = null

    @Column(
        precision = 12,
        scale = 0
    )
    var birthday: BigDecimal? = null

    @Column(length = 10)
    var phoneNumber: String? = null

    @Column
    var address: String? = null

    @Column(
        name = "\"role\"",
        length = 10
    )
    var role: String? = null

    @Column(
        name = "\"description\"",
        columnDefinition = "longtext"
    )
    var description: String? = null

    @OneToMany(mappedBy = "email")
    var emailHouses: MutableSet<House>? = null

    @ManyToMany
    @JoinTable(
        name = "favorite",
        joinColumns = [
            JoinColumn(name = "email")
        ],
        inverseJoinColumns = [
            JoinColumn(name = "house_id")
        ]
    )
    var favoriteHouses: MutableSet<House>? = null

    @OneToMany(mappedBy = "account")
    var houseNews: MutableSet<News>? = null
}
