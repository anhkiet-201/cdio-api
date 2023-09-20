package com.anhkiet.cdio4_api.controller

import com.anhkiet.cdio4_api.helper.responseHelper.content
import com.anhkiet.cdio4_api.helper.responseHelper.response
import com.anhkiet.cdio4_api.model.AddressResponseModel
import com.anhkiet.cdio4_api.service.AddressService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/address")
class AddressController(
    val addressService: AddressService
) {
    @GetMapping("/getAll")
    fun getAddress() = response {
        content(
            AddressResponseModel(
                addressService.getAll()
            )
        )
    }
}