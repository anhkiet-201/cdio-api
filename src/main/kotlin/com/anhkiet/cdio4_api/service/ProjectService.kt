package com.anhkiet.cdio4_api.service

import com.anhkiet.cdio4_api.dto.ProjectDTO
import com.anhkiet.cdio4_api.model.PageableRequestModel
import com.anhkiet.cdio4_api.model.ProjectAllRequestModel
import com.anhkiet.cdio4_api.repositories.ProjectRepository
import com.anhkiet.cdio4_api.utils.entension.toNullSafe
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class ProjectService(
    val repo: ProjectRepository
) {
    fun getAll(request: PageableRequestModel): Page<ProjectDTO> {
        val sort = Sort.by("createTime")
        val pageRequest = PageRequest.of(
            request.index,
            request.size,
            sort.descending()
        )
        return repo.findAll(
            if (request.enableSort) pageRequest.withSort(sort) else pageRequest
        ).map { ProjectDTO(it) }
    }

    fun getAll(projectAllRequestModel: ProjectAllRequestModel): Page<ProjectDTO> {
        val pageRequest = PageRequest.of(
            projectAllRequestModel.index,
            projectAllRequestModel.size,
        )
        return repo.findAll(pageRequest).map { ProjectDTO(it) }
    }

    fun getById(id: Int): ProjectDTO? = repo.findById(id).toNullSafe()?.let { ProjectDTO(it) }

//    fun search(searchModel: SearchModel): Page<ProjectDTO> {
//        val sort = Sort.by("projectName")
//        val pageRequest = PageRequest.of(searchModel.index, searchModel.size, if (searchModel.sortByDesc) sort.descending() else sort.ascending())
//        return repo.searchAllByProjectNameContainsIgnoreCaseOrProjectAddress(searchModel.key, searchModel.key, pageRequest)
//                .map {
//                    ProjectDTO(it)
//                }
//    }
}