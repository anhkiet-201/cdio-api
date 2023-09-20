package com.anhkiet.cdio4_api.service

import com.anhkiet.cdio4_api.dto.NewsDTO
import com.anhkiet.cdio4_api.model.PageableRequestModel
import com.anhkiet.cdio4_api.repositories.NewsRepository
import com.anhkiet.cdio4_api.utils.entension.toNullSafe
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class NewsService(
    val repo: NewsRepository
) {
    fun getAll(request: PageableRequestModel): Page<NewsDTO> {
        val sort = Sort.by("createTime")
        val pageRequest = PageRequest.of(
            request.index,
            request.size,
            sort.descending()
        )
        return repo.findAll(
            if (request.enableSort) pageRequest.withSort(sort) else pageRequest
        ).map { NewsDTO(it) }
    }

    fun getById(id: Int): NewsDTO? = repo.findById(id).toNullSafe()?.let { NewsDTO(it) }
}