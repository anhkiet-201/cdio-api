package com.anhkiet.cdio4_api.model

import com.anhkiet.cdio4_api.dto.NewsDTO

class NewsResponseModel(
    status: Boolean,
    val news: NewsDTO?
): BaseDataResponseModel(status, "")