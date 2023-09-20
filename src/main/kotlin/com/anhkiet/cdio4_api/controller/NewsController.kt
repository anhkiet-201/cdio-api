package com.anhkiet.cdio4_api.controller

import com.anhkiet.cdio4_api.helper.responseHelper.content
import com.anhkiet.cdio4_api.helper.responseHelper.contentPageable
import com.anhkiet.cdio4_api.helper.responseHelper.response
import com.anhkiet.cdio4_api.model.NewsResponseModel
import com.anhkiet.cdio4_api.model.PageableRequestModel
import com.anhkiet.cdio4_api.model.PageableResponseModel
import com.anhkiet.cdio4_api.service.NewsService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/news")
class NewsController(
    private val newsService: NewsService
) {
    @GetMapping("/getById")
    fun getById(id: Int) = response {
        val news = newsService.getById(id)
        content(
            NewsResponseModel(
                news != null,
                news
            )
        )
    }

    @GetMapping("/getAll")
    fun getAll(request: PageableRequestModel) = response {
        val items = newsService.getAll(request)
        contentPageable(
            items
        )
    }
}