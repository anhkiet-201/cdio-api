package com.anhkiet.cdio4_api.model

import com.anhkiet.cdio4_api.dto.CategoryDTO

class CategoryResponseModel(
        status: Boolean,
        message: String,
        val items: List<CategoryDTO>
) : BaseDataResponseModel(status, message)
