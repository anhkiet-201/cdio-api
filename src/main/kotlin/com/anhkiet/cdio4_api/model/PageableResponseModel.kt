package com.anhkiet.cdio4_api.model

data class PageableResponseModel<T>(
        val page_index: Int,
        val total_pages: Int,
        val has_next_page: Boolean,
        val items: List<T>
)
