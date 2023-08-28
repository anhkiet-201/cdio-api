package com.anhkiet.cdio4_api.dto

import com.anhkiet.cdio4_api.entities.TaiKhoan
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Column
import java.time.LocalDate

data class TaiKhoanDTO(
    val username: String? = null,

    @JsonIgnore
    val password: String? = null,

    val avatar: String? = null,

    val fullName: String? = null,

    val birthday: LocalDate? = null,

    val adress: String? = null,

    val phone: String? = null,

    val email: String? = null,

    val position: String? = null,

    val state: Int? = null,

    val description: String? = null
) {
    fun toEntity(): TaiKhoan {
        val taiKhoan = TaiKhoan()
        taiKhoan.username = username
        taiKhoan.password = password
        taiKhoan.adress = adress
        taiKhoan.avatar = avatar
        taiKhoan.fullName = fullName
        taiKhoan.birthday = birthday
        taiKhoan.phone = phone
        taiKhoan.email = email
        taiKhoan.position = position
        taiKhoan.state = state
        taiKhoan.description = description
        return taiKhoan
    }

    companion object {
        fun fromEntity(taiKhoan: TaiKhoan): TaiKhoanDTO = TaiKhoanDTO(
            username = taiKhoan.username,
            password = taiKhoan.password,
            avatar = taiKhoan.avatar,
            fullName = taiKhoan.fullName,
            birthday = taiKhoan.birthday,
            adress = taiKhoan.adress,
            phone = taiKhoan.phone,
            email = taiKhoan.email,
            position = taiKhoan.position,
            state = taiKhoan.state,
            description = taiKhoan.description
        )
    }
}