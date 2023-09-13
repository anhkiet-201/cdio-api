package com.anhkiet.cdio4_api.model

data class BaseResponseModel<T>(
        val timestamp: Long,
        val status_code: Int,
        val status_description: String,
        val data: T? = null
)
