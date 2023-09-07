package com.anhkiet.cdio4_api.model

class SearchModel(
        val key: String,
        val category: String?,
        val sortByDesc: Boolean = true,
        val filterPyPriceFrom: Long = 0,
        val filterPyPriceTo: Long = 1_000_000_000,
        size: Int = 10,
        index: Int = 0
): PageableModel(size, index)
