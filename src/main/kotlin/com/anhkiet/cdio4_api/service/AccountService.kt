package com.anhkiet.cdio4_api.service

import com.anhkiet.cdio4_api.dto.AccountDTO
import com.anhkiet.cdio4_api.model.UserRequestModel
import com.anhkiet.cdio4_api.repositories.AccountRepository
import org.springframework.mail.MailException
import org.springframework.mail.MailSender
import org.springframework.mail.SimpleMailMessage
import org.springframework.security.crypto.bcrypt.BCrypt
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.*

@Service
class AccountService(
    private val repo: AccountRepository,
    private val mailSender: MailSender
) {
    fun findByEmail(email: String): AccountDTO? = when (val account = repo.findByEmail(email)) {
        null -> null
        else -> AccountDTO(account)
    }

    fun create(account: AccountDTO): AccountDTO = AccountDTO(repo.save(account.toEntity()))
    fun existsByEmail(username: String): Boolean = repo.existsByEmail(username)
    fun createResetPasswordTokenSendToEmail(account: AccountDTO): Boolean {
        var resetPasswordToken = ""
        account.resetPasswordToken?.let {
            val expiryDate = it.split("/").last().toLongOrNull()
            expiryDate?.let {
                if (it <= Date().time)
                    resetPasswordToken = account.resetPasswordToken
            }
        }
        if (resetPasswordToken.isBlank() || resetPasswordToken.isEmpty()) {
            val currentTime = Date().time
            val token = currentTime % 10_000_000
            val expiryDate = "${currentTime + 9_000}"
            resetPasswordToken = "${String.format("%6d", token)}/$expiryDate"
            val saveAccount = account.toEntity()
            saveAccount.resetPasswordToken = resetPasswordToken
            repo.save(saveAccount)
        }
        val message = SimpleMailMessage()
        message.from = "igg.anhkiet@gmail.com"
        message.setTo(account.email)
        message.subject = "Reset your password"
        message.text = resetPasswordToken.split("/").first()
        try {
            mailSender.send(message)
        } catch (e: MailException) {
            print(e.message)
            return false
        }
        return true
    }

    fun updatePassword(email: String, hashPassword: String, token: String? = null): AccountDTO? {
        repo.findByEmail(email)?.let { account ->
            token?.let {
                val expiryDate = it.toLongOrNull()
                val accountToken = account.resetPasswordToken?.split("/")?.first() ?: ""
                if (!it.equals(accountToken)) return null
                expiryDate?.let {
                    if (it <= Date().time) {
                        return AccountDTO(
                            repo.save(
                                account.apply {
                                    password = hashPassword
                                    resetPasswordToken = null
                                }
                            )
                        )
                    } else {
                        return null
                    }
                }
            }
            return AccountDTO(
                repo.save(
                    account.apply {
                        password = BCrypt.hashpw(hashPassword, BCrypt.gensalt())
                    }
                )
            )
        }
        return null
    }

    fun updateUser(request: UserRequestModel) : AccountDTO? {
        val lastUser = repo.findByEmail(request.email ?: "") ?: return null
        lastUser.email = request.email
        lastUser.avatarUrl = request.avatarUrl
        lastUser.fullName = request.fullName
        lastUser.birthday = request.birthday
        lastUser.phoneNumber = request.phoneNumber
        lastUser.address = request.address
        lastUser.description = request.description


        return AccountDTO(repo.save(lastUser))
    }
}