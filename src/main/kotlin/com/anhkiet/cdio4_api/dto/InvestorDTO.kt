//package com.anhkiet.cdio4_api.dto
//
//import com.anhkiet.cdio4_api.entities.Investor
//import com.anhkiet.cdio4_api.entities.Project
//import com.fasterxml.jackson.annotation.JsonIgnore
//
//data class InvestorDTO(
//    @JsonIgnore
//    val investorId: Int,
//
//    val investorName: String,
//
//    val logoUrl: String? = null,
//
//    val description: String? = null,
//
//    val isActive: Boolean,
//
//    @JsonIgnore
//    val investorProjects: List<ProjectDTO> = emptyList()
//) {
//    constructor(investor: Investor) : this(
//        investorId = investor.investorId,
//        investorName = investor.investorName,
//        logoUrl = investor.logoUrl,
//        description = investor.description,
//        isActive = investor.isActive,
//        investorProjects = investor.investorProjects?.map { ProjectDTO(it) } ?: emptyList()
//    )
//
//    fun toEntity(): Investor {
//        val investor = Investor()
//        investor.investorId = investorId
//        investor.investorName = investorName
//        investor.logoUrl = logoUrl
//        investor.description = description
//        investor.isActive = isActive
//        investor.investorProjects = investorProjects.map { it.toEntity() }.toMutableSet()
//        return investor
//    }
//}
