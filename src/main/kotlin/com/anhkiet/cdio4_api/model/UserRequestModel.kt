package com.anhkiet.cdio4_api.model

import java.math.BigDecimal

data class UserRequestModel(
        val email: String?,
        val avatarUrl: String?,
        val fullName: String? ,
        val birthday: BigDecimal? ,
        val phoneNumber: String?,
        val address: String? ,
        val description: String?
)
