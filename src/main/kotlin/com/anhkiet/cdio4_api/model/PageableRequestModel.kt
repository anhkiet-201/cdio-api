package com.anhkiet.cdio4_api.model

class PageableRequestModel(
    size: Int,
    index: Int,
    val enableSort: Boolean
) : PageableModel(size, index)