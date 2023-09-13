package com.anhkiet.cdio4_api.model

import com.anhkiet.cdio4_api.dto.AccountDTO

class AuthResponseModel(
        status: Boolean,
        message: String,
        val token: String? = null,
        val user: AccountDTO? = null,
): BaseDataResponseModel(status, message)
