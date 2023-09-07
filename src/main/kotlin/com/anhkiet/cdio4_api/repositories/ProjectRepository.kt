package com.anhkiet.cdio4_api.repositories


import com.anhkiet.cdio4_api.entities.Project
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository


interface ProjectRepository : JpaRepository<Project, Int> {
    fun searchAllByProjectNameContainsIgnoreCaseOrProjectAddress(projectName: String, projectAddress: String, pageable: Pageable): Page<Project>
}
