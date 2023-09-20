package com.anhkiet.cdio4_api.model

import com.anhkiet.cdio4_api.dto.AddressDTO

class AddressResponseModel(
    val items: List<AddressDTO>
) : BaseDataResponseModel(true, "")