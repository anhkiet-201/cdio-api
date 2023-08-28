package com.anhkiet.cdio4_api.controller

import com.anhkiet.cdio4_api.dto.TaiKhoanDTO
import com.anhkiet.cdio4_api.helper.*
import com.anhkiet.cdio4_api.helper.responseHelper.*
import com.anhkiet.cdio4_api.model.LoginModel
import com.anhkiet.cdio4_api.service.TaiKhoanService
import com.anhkiet.cdio4_api.service.TokenService
import com.nimbusds.jose.Payload
import org.springframework.http.HttpStatus
import org.springframework.http.server.ServerHttpAsyncRequestControl
import org.springframework.security.crypto.bcrypt.BCrypt
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class AuthController(
    private val tokenService: TokenService,
    private val taiKhoanService: TaiKhoanService
) {
    @PostMapping("/login")
    fun login(@RequestBody payload: LoginModel) = response {
        when (val taiKhoan = taiKhoanService.findByUserName(payload.username)) {
            null -> content(
                HttpStatus.NOT_FOUND,
                "login failure",
                "reason" to "Username not match!"
            )

            else -> if (!BCrypt.checkpw(payload.password, taiKhoan.password))
                content(
                    HttpStatus.UNAUTHORIZED,
                    "login failure",
                    "reason" to "Password not match!"
                )
            else {
                print(TaiKhoanDTO.fromEntity(taiKhoan))
                content(
                    HttpStatus.OK,
                    "ok",
                    "token" to tokenService.createToken(taiKhoan.username!!, taiKhoan.position!!),
                    "user" to TaiKhoanDTO.fromEntity(taiKhoan)
                )
            }
        }
    }

    @PostMapping("/register")
    fun register(@RequestBody payload: LoginModel) = response {
        when (taiKhoanService.existsByUsername(payload.username)) {
            true -> content(
                HttpStatus.UNAUTHORIZED,
                "register failure",
                "reason" to "Email already exists",
            )

            else -> {
                val taikhoan = taiKhoanService.createTaiKhoan(
                    TaiKhoanDTO(
                        username = payload.username,
                        password = BCrypt.hashpw(payload.password, BCrypt.gensalt()),
                        position = "customer"
                    )
                )
                content(
                    HttpStatus.OK,
                    "register successful!",
                    "token" to tokenService.createToken(taikhoan.username!!, taikhoan.position!!),
                    "account" to TaiKhoanDTO.fromEntity(taikhoan)
                )
            }
        }
    }

}