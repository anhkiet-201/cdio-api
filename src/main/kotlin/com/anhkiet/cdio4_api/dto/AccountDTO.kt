package com.anhkiet.cdio4_api.dto

import com.anhkiet.cdio4_api.entities.Account
import com.anhkiet.cdio4_api.entities.House
import com.anhkiet.cdio4_api.entities.News
import com.fasterxml.jackson.annotation.JsonIgnore
import java.math.BigDecimal

data class AccountDTO(
    val email: String,

    @JsonIgnore
    val password: String? = null,

    val avatarUrl: String? = null,

    val fullName: String? = null,

    val birthday: BigDecimal? = null,

    val phoneNumber: String? = null,

    val address: String? = null,

    val role: String? = null,

    val description: String? = null,

    @JsonIgnore
    val resetPasswordToken: String? = null
) {

    constructor(account: Account) : this(
        email = account.email ?: "",
        password = account.password,
        avatarUrl = account.avatarUrl,
        fullName = account.fullName,
        birthday = account.birthday,
        phoneNumber = account.phoneNumber,
        address = account.address,
        role = account.role,
        description = account.description,
        resetPasswordToken = account.resetPasswordToken
    )

    fun toEntity(): Account {
        val account = Account()
        account.email = email
        account.password = password
        account.avatarUrl = avatarUrl
        account.fullName = fullName
        account.birthday = birthday
        account.phoneNumber = phoneNumber
        account.address = address
        account.role = role
        account.description = description
        account.resetPasswordToken = resetPasswordToken
        return account
    }
}
