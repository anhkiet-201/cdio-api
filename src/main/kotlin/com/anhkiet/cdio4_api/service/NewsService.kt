package com.anhkiet.cdio4_api.service

import com.anhkiet.cdio4_api.dto.NewsDTO
import com.anhkiet.cdio4_api.repositories.NewsRepository
import org.springframework.stereotype.Service

@Service
class NewsService(
    val repo: NewsRepository
) {
    fun getNewestNews(limit: Int = 5): List<NewsDTO> = repo.findAll().let {
        if (it.count() < 3) it else it.subList(0, 2)
    }.map {
        NewsDTO(it)
    }.toList()
}