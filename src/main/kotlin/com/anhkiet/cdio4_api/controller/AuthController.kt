package com.anhkiet.cdio4_api.controller

import com.anhkiet.cdio4_api.helper.*
import com.anhkiet.cdio4_api.helper.responseHelper.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class AuthController {
    @GetMapping("/demo")
    fun demo(input: String) = response {
        content(
            Status.OK,
            "ok",
            "demo" to objectOf(
                "text1" to "This is demo api 1",
                "text2" to "This is demo api 2",
                "text" to listOf(
                    "Hello",
                    "Xin chao"
                )
            )
        )
    }
}