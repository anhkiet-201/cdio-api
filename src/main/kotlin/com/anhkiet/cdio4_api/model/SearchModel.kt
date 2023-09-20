package com.anhkiet.cdio4_api.model

class SearchModel(
        val key: String,
        var province: String? = null,
        var district: String? = null,
        var wards: String? = null,
        var street: String? = null,
        var projectName: String? = null,
        val sortByDesc: Boolean = true,
        size: Int = 10,
        index: Int = 0
): PageableModel(size, index)
