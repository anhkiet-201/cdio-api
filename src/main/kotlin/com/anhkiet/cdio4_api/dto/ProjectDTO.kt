package com.anhkiet.cdio4_api.dto

import com.anhkiet.cdio4_api.entities.Project
import com.fasterxml.jackson.annotation.JsonIgnore

data class ProjectDTO(
    @JsonIgnore
    val projectId: Int,

    val projectName: String,

    val projectStatus: String,

    val projectAddress: String? = null,

    val contactInfo: String? = null,

    val projectThumbNailUrl: String? = null,

    val projectDescription: String? = null,
//
//    val investor: InvestorDTO? = null
) {
    constructor(project: Project) : this(
        projectId = project.projectId,
        projectName = project.projectName,
        projectStatus = project.projectStatus,
        contactInfo = project.contactInfo,
        projectThumbNailUrl = project.projectThumbNailUrl,
        projectDescription = project.projectDescription,
//        investor = project.investor?.let { InvestorDTO(it) }
    )

    fun toEntity(): Project {
        val project = Project()
        project.projectId = projectId
        project.projectName = projectName
        project.projectStatus = projectStatus
        project.contactInfo = contactInfo
        project.projectThumbNailUrl = projectThumbNailUrl
        project.projectDescription = projectDescription
//        project.investor = investor?.toEntity()
        return project
    }
}
