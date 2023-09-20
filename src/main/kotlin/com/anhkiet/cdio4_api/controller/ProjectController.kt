package com.anhkiet.cdio4_api.controller

import com.anhkiet.cdio4_api.helper.responseHelper.contentPageable
import com.anhkiet.cdio4_api.helper.responseHelper.response
import com.anhkiet.cdio4_api.model.ProjectAllRequestModel
import com.anhkiet.cdio4_api.service.ProjectService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ProjectController(
    private val projectService: ProjectService
) {
    @GetMapping("/all-project")
    fun getAllProject(projectAllRequestModel: ProjectAllRequestModel) = response {
        contentPageable(
            projectService.getAll(projectAllRequestModel)
        )
    }
}