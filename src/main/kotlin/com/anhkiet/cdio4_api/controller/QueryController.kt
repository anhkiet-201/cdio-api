package com.anhkiet.cdio4_api.controller

import com.anhkiet.cdio4_api.helper.responseHelper.content
import com.anhkiet.cdio4_api.helper.responseHelper.contentPageable
import com.anhkiet.cdio4_api.helper.responseHelper.response
import com.anhkiet.cdio4_api.model.AddressResponseModel
import com.anhkiet.cdio4_api.model.HomeResponseModel
import com.anhkiet.cdio4_api.model.PageableRequestModel
import com.anhkiet.cdio4_api.model.SearchModel
import com.anhkiet.cdio4_api.service.AddressService
import com.anhkiet.cdio4_api.service.HouseService
import com.anhkiet.cdio4_api.service.NewsService
import com.anhkiet.cdio4_api.service.ProjectService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class QueryController(
    val houseService: HouseService,
    val projectService: ProjectService,
    val newsService: NewsService
) {
    @GetMapping("/home")
    fun home(request: PageableRequestModel = PageableRequestModel(3, 0, true)) = response {
        val houseNewest = houseService.getAll(request).toList()
        val projectNewest = projectService.getAll(request).toList()
        val newsNewest = newsService.getAll(request).toList()
        content(
                HomeResponseModel(
                    true,
                    "",
                    houseNewest,
                    projectNewest,
                    newsNewest
                )
        )
    }

    @GetMapping("/search")
    fun search(payload: SearchModel) = response {
        val houseResult = houseService.search(payload)
        contentPageable(houseResult)
    }
}