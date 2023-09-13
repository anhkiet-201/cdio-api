package com.anhkiet.cdio4_api.model

import com.anhkiet.cdio4_api.dto.HouseDTO
import com.anhkiet.cdio4_api.dto.NewsDTO
import com.anhkiet.cdio4_api.dto.ProjectDTO

class HomeResponseModel(
    status: Boolean,
    message: String,
    val houseNewest: List<HouseDTO>,
    val projectNewest: List<ProjectDTO>,
    val newsNewest: List<NewsDTO>
) : BaseDataResponseModel(status, message)