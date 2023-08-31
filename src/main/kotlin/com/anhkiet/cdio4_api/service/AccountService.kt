package com.anhkiet.cdio4_api.service

import com.anhkiet.cdio4_api.dto.AccountDTO
import com.anhkiet.cdio4_api.entities.Account
import com.anhkiet.cdio4_api.repositories.AccountRepository
import org.springframework.stereotype.Service

@Service
class AccountService(
    private val respo: AccountRepository
) {
    fun findByEmail(email: String): Account? = respo.findByEmail(email)
    fun create(account: AccountDTO): Account = respo.save(account.toEntity())
    fun existsByEmail(username: String): Boolean = respo.existsByEmail(username)
}