package com.anhkiet.cdio4_api.service

import com.anhkiet.cdio4_api.dto.CategoryDTO
import com.anhkiet.cdio4_api.repositories.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryService(
        private val repo: CategoryRepository
) {
    fun findAll(): List<CategoryDTO> = repo.findAll().map { CategoryDTO(it) }
}