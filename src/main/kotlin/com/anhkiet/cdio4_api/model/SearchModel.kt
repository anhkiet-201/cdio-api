package com.anhkiet.cdio4_api.model

data class SearchModel(
        val key: String,
        val category: String?,
        val sortByDesc: Boolean = true
)
