//package com.anhkiet.cdio4_api.entities
//
//import jakarta.persistence.Column
//import jakarta.persistence.Entity
//import jakarta.persistence.GeneratedValue
//import jakarta.persistence.GenerationType
//import jakarta.persistence.Id
//import jakarta.persistence.OneToMany
//
//
//@Entity
//class Investor {
//
//    @Id
//    @Column(
//        nullable = false,
//        updatable = false
//    )
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    var investorId: Int = -1
//
//    @Column
//    var investorName: String = ""
//
//    @Column
//    var logoUrl: String? = null
//
//    @Column(
//        name = "\"description\"",
//        columnDefinition = "longtext"
//    )
//    var description: String? = null
//
//    @Column
//    var isActive: Boolean = true
//
//    @OneToMany(mappedBy = "investor")
//    var investorProjects: MutableSet<Project>? = null
//
//}
