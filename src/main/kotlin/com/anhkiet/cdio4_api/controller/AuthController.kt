package com.anhkiet.cdio4_api.controller

import com.anhkiet.cdio4_api.helper.JsonResponseType
import com.anhkiet.cdio4_api.helper.ResponseBuilder
import com.anhkiet.cdio4_api.helper.response
import com.anhkiet.cdio4_api.helper.responseCustom
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class AuthController {
    @GetMapping("/demo")
    fun demo(): JsonResponseType {
        return ResponseBuilder(
            ResponseBuilder.OK,
            "OK",
            "message" to "this is demo api"
        ).toResponse()
    }
}