package com.anhkiet.cdio4_api.model

import com.nimbusds.jose.Payload

data class LoginModel(
    val email: String,
    val password: String
)
