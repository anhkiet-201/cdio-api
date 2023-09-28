package com.anhkiet.cdio4_api.controller

import com.anhkiet.cdio4_api.helper.responseHelper.content
import com.anhkiet.cdio4_api.helper.responseHelper.response
import com.anhkiet.cdio4_api.model.HouseResponseModel
import com.anhkiet.cdio4_api.model.UserRequestModel
import com.anhkiet.cdio4_api.model.UserResponseModel
import com.anhkiet.cdio4_api.service.AccountService
import com.anhkiet.cdio4_api.service.HouseService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserController(
        private val accountService: AccountService
) {
    @GetMapping("/getByEmail")
    fun getUserByEmail(email: String) = response {
        val user = accountService.findByEmail(email)
        content(
                UserResponseModel(
                        user != null,
                        user
                )
        )
    }

    @PostMapping("/updateUser")
    fun updateUser(request: UserRequestModel) = response {
        val updateUser = accountService.updateUser(request)
        content(
                UserResponseModel(
                        updateUser != null,
                        updateUser
                )
        )
    }
}