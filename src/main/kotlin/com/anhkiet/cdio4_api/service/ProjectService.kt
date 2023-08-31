package com.anhkiet.cdio4_api.service

import com.anhkiet.cdio4_api.dto.ProjectDTO
import com.anhkiet.cdio4_api.repositories.ProjectRepository
import org.springframework.stereotype.Service

@Service
class ProjectService(
    val repo: ProjectRepository
) {
    fun getNewestProject(limit: Int = 3): List<ProjectDTO> = repo.findAll().let {
        if (it.count() < 3) it else it.subList(0, 2)
    }.map {
        ProjectDTO(it)
    }.toList()
}