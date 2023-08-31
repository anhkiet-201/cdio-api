package com.anhkiet.cdio4_api.repositories

import com.anhkiet.cdio4_api.entities.Account
import org.springframework.data.jpa.repository.JpaRepository


interface AccountRepository : JpaRepository<Account, String> {
    fun findByEmail(email: String): Account?
    fun existsByEmail(email: String): Boolean
}
