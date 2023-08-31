package com.anhkiet.cdio4_api.dto

import com.anhkiet.cdio4_api.entities.Category
import com.anhkiet.cdio4_api.entities.House
import com.fasterxml.jackson.annotation.JsonIgnore

data class CategoryDTO(
    val categoryId: Int,

    val categoryName: String,

    val description: String? = null,

    @JsonIgnore
    var categoryHouses: List<House> = emptyList()
) {
    constructor(
        category: Category
    ) : this(
        categoryId = category.categoryId,
        categoryName = category.categoryName,
        description = category.description,
        categoryHouses = category.categoryHouses?.toList() ?: emptyList()
    )

    fun toEntity(): Category {
        val category = Category()
        category.categoryId = categoryId
        category.categoryName = categoryName
        category.description = description
        category.categoryHouses = categoryHouses.toMutableSet()
        return category
    }
}
