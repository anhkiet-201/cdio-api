package com.anhkiet.cdio4_api.controller

import com.anhkiet.cdio4_api.dto.AccountDTO
import com.anhkiet.cdio4_api.helper.*
import com.anhkiet.cdio4_api.helper.responseHelper.*
import com.anhkiet.cdio4_api.model.*
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
                    AuthResponseModel(
                            false,
                            "Username not match!"
                    )
            )

            else -> if (!BCrypt.checkpw(payload.password, account.password))
                content(
                        AuthResponseModel(
                                false,
                                "Password not match!"
                        )
                )
            else {
                content(
                        AuthResponseModel(
                                true,
                                "Login successful!",
                                tokenService.createToken(account.email, account.role!!),
                                account
                        )
                )
            }
        }
    }

    @PostMapping("/register")
    fun register(@RequestBody payload: RegisterModel) = response {
        when (accountService.existsByEmail(payload.email)) {
            true -> content(
                    AuthResponseModel(
                            false,
                            "Username already exists"
                    )
            )

            else -> {
                val account = accountService.create(
                        AccountDTO(
                                email = payload.email,
                                password = BCrypt.hashpw(payload.password, BCrypt.gensalt()),
                                role = "customer",
                                fullName = payload.username
                        )
                )
                content(
                        AuthResponseModel(
                                true,
                                "Register successful!",
                                tokenService.createToken(account.email, account.role!!),
                                account
                        )
                )
            }
        }
    }

    @PostMapping("/getResetPasswordToken")
    fun getResetPasswordToken(@RequestBody email: String) = response {
        when (val account = accountService.findByEmail(email)) {
            null -> content(
                    BaseDataResponseModel(
                            false,
                            "Email do not exists"
                    )
            )

            else -> {
                val result = accountService.createResetPasswordTokenSendToEmail(account)
                content(
                        BaseDataResponseModel(
                                result,
                                "Reset code is sent to your email!"
                        )
                )
            }
        }
    }

    @PostMapping("/setNewPassword")
    fun setNewPassword(@RequestBody payload: ResetPasswordModel) = response {
        val hashpw = BCrypt.hashpw(payload.password, BCrypt.gensalt())
        when (val account = accountService.updatePassword(payload.email, hashpw, payload.token)) {
            null -> content(
                AuthResponseModel(
                    false,
                    "Update password error!"
                )
            )

            else -> content(
                AuthResponseModel(
                    true,
                    "Update password successful!",
                    tokenService.createToken(account.email, account.role!!),
                    account
                )
            )
        }
    }
}