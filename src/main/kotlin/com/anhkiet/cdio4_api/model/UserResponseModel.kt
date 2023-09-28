package com.anhkiet.cdio4_api.model

import com.anhkiet.cdio4_api.dto.AccountDTO

class UserResponseModel(
        status: Boolean,
        val user: AccountDTO?
) : BaseDataResponseModel(status, "")