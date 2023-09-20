package com.anhkiet.cdio4_api.controller

import com.anhkiet.cdio4_api.helper.responseHelper.content
import com.anhkiet.cdio4_api.helper.responseHelper.contentPageable
import com.anhkiet.cdio4_api.helper.responseHelper.response
import com.anhkiet.cdio4_api.model.ProjectAllRequestModel
import com.anhkiet.cdio4_api.model.ProjectResponseModel
import com.anhkiet.cdio4_api.service.ProjectService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/project")
class ProjectController(
    private val projectService: ProjectService
) {
    @GetMapping("/getAll")
    fun getAllProject(projectAllRequestModel: ProjectAllRequestModel) = response {
        contentPageable(
            projectService.getAll(projectAllRequestModel)
        )
    }

    @GetMapping("/getById")
    fun getProjectById(id: Int) = response {
        val project = projectService.getById(id)
        content(
            ProjectResponseModel(
                project != null,
                project
            )
        )
    }
}