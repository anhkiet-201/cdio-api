package com.anhkiet.cdio4_api.service

import com.anhkiet.cdio4_api.dto.AccountDTO
import com.anhkiet.cdio4_api.entities.Account
import com.anhkiet.cdio4_api.repositories.AccountRepository
import org.springframework.stereotype.Service

@Service
class AccountService(
    private val repo: AccountRepository
) {
    fun findByEmail(email: String): AccountDTO? = when (val account = repo.findByEmail(email)) {
        null -> null
        else -> AccountDTO(account)
    }
    fun create(account: AccountDTO): AccountDTO = AccountDTO(repo.save(account.toEntity()))
    fun existsByEmail(username: String): Boolean = repo.existsByEmail(username)
}