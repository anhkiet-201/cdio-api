package com.anhkiet.cdio4_api.repositories

import com.anhkiet.cdio4_api.entities.TaiKhoan
import org.springframework.data.jpa.repository.JpaRepository

interface TaiKhoanRepository : JpaRepository<TaiKhoan, Int> {
    fun findByUsername(username: String): TaiKhoan?
    fun existsByUsername(username: String): Boolean
}
