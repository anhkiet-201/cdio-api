package com.anhkiet.cdio4_api.dto

import com.anhkiet.cdio4_api.entities.Category
import com.anhkiet.cdio4_api.entities.House
import com.fasterxml.jackson.annotation.JsonIgnore

data class CategoryDTO(

    @JsonIgnore
    val categoryId: Int,

    val categoryName: String,

    val description: String? = null
) {
    constructor(
        category: Category
    ) : this(
        categoryId = category.categoryId,
        categoryName = category.categoryName,
        description = category.description,
    )

    fun toEntity(): Category {
        val category = Category()
        category.categoryId = categoryId
        category.categoryName = categoryName
        category.description = description
        return category
    }
}
