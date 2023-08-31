package com.anhkiet.cdio4_api.dto

import com.anhkiet.cdio4_api.entities.Account
import com.anhkiet.cdio4_api.entities.House
import com.anhkiet.cdio4_api.entities.News
import com.fasterxml.jackson.annotation.JsonIgnore
import java.math.BigDecimal

data class AccountDTO(
    val email: String? = null,

    @JsonIgnore
    val password: String? = null,

    val avatarUrl: String? = null,

    val fullName: String? = null,

    val birthday: BigDecimal? = null,

    val phoneNumber: String? = null,

    val address: String? = null,

    val role: String? = null,

    val description: String? = null,

    val houseOwner: List<House> = emptyList(),

    val favoriteHouses: List<House> = emptyList(),

    val houseNews: List<News> = emptyList()
) {

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
        return account
    }

    companion object {
        fun fromEntity(account: Account): AccountDTO = AccountDTO(
            email = account.email,
            password = account.password,
            avatarUrl =  account.avatarUrl,
            fullName = account.fullName,
            birthday = account.birthday,
            phoneNumber = account.phoneNumber,
            address = account.address,
            role = account.role,
            description = account.description,
            houseOwner = account.emailHouses?.toList() ?: emptyList(),
            favoriteHouses = account.favoriteHouses?.toList() ?: emptyList(),
            houseNews = account.houseNews?.toList() ?: emptyList(),
            )
    }
}
