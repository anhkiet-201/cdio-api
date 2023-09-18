package com.anhkiet.cdio4_api.utils.heplper

import com.anhkiet.cdio4_api.dto.AccountDTO
import com.anhkiet.cdio4_api.service.AccountService
import com.anhkiet.cdio4_api.service.TokenService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes

@Service
class RequestHelper(
    private val tokenService: TokenService
) {
    fun getCurrentRequest(): HttpServletRequest? = RequestContextHolder.getRequestAttributes()?.let {
        (it as ServletRequestAttributes).request
    }

    fun getCurrentUserRequest(
    ): AccountDTO? {
        return getCurrentRequest()?.let {
            tokenService.parseToken(it.getHeader("authorization"))
        }
    }
}
