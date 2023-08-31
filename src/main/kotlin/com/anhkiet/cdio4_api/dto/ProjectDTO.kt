package com.anhkiet.cdio4_api.dto

import com.anhkiet.cdio4_api.entities.House
import com.anhkiet.cdio4_api.entities.Investor
import com.anhkiet.cdio4_api.entities.Project
import com.fasterxml.jackson.annotation.JsonIgnore

data class ProjectDTO(
    val projectId: Int,

    val projectName: String,

    val projectStatus: String,

    val projectAddress: String? = null,

    val contactInfo: String? = null,

    val projectThumbNailUrl: String? = null,

    val projectDescription: String? = null,

    @JsonIgnore
    val projectHouses: List<House> = emptyList(),

    @JsonIgnore
    val investor: Investor? = null
) {
    constructor(project: Project) : this(
        projectId = project.projectId,
        projectName = project.projectName,
        projectStatus = project.projectStatus,
        projectAddress = project.projectAddress,
        contactInfo = project.contactInfo,
        projectThumbNailUrl = project.projectThumbNailUrl,
        projectDescription = project.projectDescription,
        projectHouses = project.projectHouses?.toList() ?: emptyList(),
        investor = project.investor
    )

    fun toEntity(): Project {
        val project = Project()
        project.projectId = projectId
        project.projectName = projectName
        project.projectStatus = projectStatus
        project.projectAddress = projectAddress
        project.contactInfo = contactInfo
        project.projectThumbNailUrl = projectThumbNailUrl
        project.projectDescription = projectDescription
        project.projectHouses = projectHouses.toMutableSet()
        project.investor = investor
        return project
    }
}
