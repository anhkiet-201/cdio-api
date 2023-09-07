package com.anhkiet.cdio4_api.controller

import com.anhkiet.cdio4_api.helper.responseHelper.content
import com.anhkiet.cdio4_api.helper.responseHelper.response
import com.anhkiet.cdio4_api.model.SearchModel
import com.anhkiet.cdio4_api.service.HouseService
import com.anhkiet.cdio4_api.service.NewsService
import com.anhkiet.cdio4_api.service.ProjectService
import com.nimbusds.jose.Payload
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class QueryController(
    val houseService: HouseService,
    val projectService: ProjectService,
    val newsService: NewsService,
        val x: Int? = null
) {
    @RequestMapping("/home")
    fun home() = response {
        val houseNewest = houseService.getNewestHouse()
        val projectNewest = projectService.getNewestProject()
        val newsNewest = newsService.getNewestNews()
        content(
            "house_newest" to houseNewest,
            "project_newest" to projectNewest,
            "news_newest" to newsNewest
        )
    }

    @GetMapping("/search")
    fun search(@RequestBody payload: SearchModel) = response {
        val houseResult = houseService.search(payload)
        val projectResult = projectService.search(payload)
        content(
                "houses" to houseResult,
                "projects" to projectResult
        )
    }
}