package com.anhkiet.cdio4_api.model

data class ResetPasswordModel(
    val email: String,
    val password: String,
    val token: String
)
