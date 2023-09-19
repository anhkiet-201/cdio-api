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


@Entity
class Project {

    @Id
    @Column(
        nullable = false,
        updatable = false
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var projectId: Int = -1

    @Column
    var projectName: String = ""

    @Column(
        nullable = false,
        length = 20
    )
    var projectStatus: String = ""

    @Column(length = 100)
    var contactInfo: String? = null

    @Column
    var projectThumbNailUrl: String? = null

    @Column(columnDefinition = "longtext")
    var projectDescription: String? = null

    @OneToMany(mappedBy = "project")
    var projectHouses: MutableSet<House>? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "investor_id",
        nullable = false
    )
    var investor: Investor? = null

}
