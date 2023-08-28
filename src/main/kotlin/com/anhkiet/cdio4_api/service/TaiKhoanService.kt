package com.anhkiet.cdio4_api.service

import com.anhkiet.cdio4_api.dto.TaiKhoanDTO
import com.anhkiet.cdio4_api.entities.TaiKhoan
import com.anhkiet.cdio4_api.repositories.TaiKhoanRepository
import org.springframework.stereotype.Service

@Service
class TaiKhoanService(
    private val respo: TaiKhoanRepository
) {
    fun findByUserName(username: String): TaiKhoan? = respo.findByUsername(username)
    fun createTaiKhoan(taikhoan: TaiKhoanDTO): TaiKhoan = respo.save(taikhoan.toEntity())
    fun existsByUsername(username: String): Boolean = respo.existsByUsername(username)
}