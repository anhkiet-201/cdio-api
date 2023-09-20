package com.anhkiet.cdio4_api.model

import com.anhkiet.cdio4_api.dto.HouseDTO

class HouseResponseModel(
    status: Boolean,
    val house: HouseDTO?
) : BaseDataResponseModel(status, "")