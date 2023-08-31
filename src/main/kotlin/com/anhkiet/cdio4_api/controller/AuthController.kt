package com.anhkiet.cdio4_api.controller

import com.anhkiet.cdio4_api.dto.AccountDTO
import com.anhkiet.cdio4_api.helper.*
import com.anhkiet.cdio4_api.helper.responseHelper.*
import com.anhkiet.cdio4_api.model.LoginModel
import com.anhkiet.cdio4_api.model.RegisterModel
import com.anhkiet.cdio4_api.service.AccountService
import com.anhkiet.cdio4_api.service.TokenService
import org.springframework.security.crypto.bcrypt.BCrypt
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class AuthController(
    private val tokenService: TokenService,
    private val accountService: AccountService
) {
    @PostMapping("/login")
    fun login(@RequestBody payload: LoginModel) = response {
        when (val account = accountService.findByEmail(payload.email)) {
            null -> content(
                "message" to "login failure",
                "reason" to "Username not match!"
            )

            else -> if (!BCrypt.checkpw(payload.password, account.password))
                content(
                    "message" to "login failure",
                    "reason" to "Password not match!"
                )
            else {
                content(
                    "message" to "login successful",
                    "token" to tokenService.createToken(account.email, account.role!!),
                    "user" to account
                )
            }
        }
    }

    @PostMapping("/register")
    fun register(@RequestBody payload: RegisterModel) = response {
        when (accountService.existsByEmail(payload.email)) {
            true -> content(
                "message" to "register failure",
                "reason" to "Username already exists",
            )

            else -> {
                val account = accountService.create(
                    AccountDTO(
                        email = payload.email,
                        password = BCrypt.hashpw(payload.password, BCrypt.gensalt()),
                        role = "customer"
                    )
                )
                content(
                    "message" to "register successful!",
                    "token" to tokenService.createToken(account.email, account.role!!),
                    "account" to account
                )
            }
        }
    }
}