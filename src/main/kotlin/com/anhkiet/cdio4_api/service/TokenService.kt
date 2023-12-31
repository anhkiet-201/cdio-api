package com.anhkiet.cdio4_api.service

import com.anhkiet.cdio4_api.dto.AccountDTO
import com.anhkiet.cdio4_api.entities.Account
import org.springframework.security.oauth2.jwt.JwsHeader
import org.springframework.security.oauth2.jwt.JwtClaimsSet
import org.springframework.security.oauth2.jwt.JwtDecoder
import org.springframework.security.oauth2.jwt.JwtEncoder
import org.springframework.security.oauth2.jwt.JwtEncoderParameters
import org.springframework.stereotype.Service
import java.lang.Exception
import java.time.Instant
import java.time.temporal.ChronoUnit

@Service
class TokenService(
    private val jwtDecoder: JwtDecoder,
    private val jwtEncoder: JwtEncoder,
    private val accountService: AccountService
) {

    fun createToken(email: String, role: String): String {
        val jwsHeader = JwsHeader.with { "HS256" }.build()
        val claims = JwtClaimsSet.builder()
            .issuedAt(Instant.now())
            .expiresAt(Instant.now().plus(30L, ChronoUnit.DAYS))
            .subject(email)
            .claim("email", email)
            .claim("position",role)
            .build()
        return jwtEncoder.encode(JwtEncoderParameters.from(jwsHeader, claims)).tokenValue
    }

    fun parseToken(token: String): AccountDTO? {
        return try {
            val jwt = jwtDecoder.decode(token)
            val email = jwt.claims["email"] as String
            return accountService.findByEmail(email)
        } catch (e: Exception) {
            null
        }
    }
}