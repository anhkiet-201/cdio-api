package com.anhkiet.cdio4_api.service

import com.anhkiet.cdio4_api.dto.HouseDTO
import com.anhkiet.cdio4_api.dto.ProjectDTO
import com.anhkiet.cdio4_api.model.ProjectAllRequestModel
import com.anhkiet.cdio4_api.model.SearchModel
import com.anhkiet.cdio4_api.repositories.ProjectRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
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

    fun getAll(projectAllRequestModel: ProjectAllRequestModel): Page<ProjectDTO> {
        val pageRequest = PageRequest.of(
            projectAllRequestModel.index,
            projectAllRequestModel.size,
        )
        return repo.findAll(pageRequest).map { ProjectDTO(it) }
    }

//    fun search(searchModel: SearchModel): Page<ProjectDTO> {
//        val sort = Sort.by("projectName")
//        val pageRequest = PageRequest.of(searchModel.index, searchModel.size, if (searchModel.sortByDesc) sort.descending() else sort.ascending())
//        return repo.searchAllByProjectNameContainsIgnoreCaseOrProjectAddress(searchModel.key, searchModel.key, pageRequest)
//                .map {
//                    ProjectDTO(it)
//                }
//    }
}