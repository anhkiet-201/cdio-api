package com.anhkiet.cdio4_api.controller

import com.anhkiet.cdio4_api.helper.responseHelper.content
import com.anhkiet.cdio4_api.helper.responseHelper.response
import com.anhkiet.cdio4_api.model.HouseResponseModel
import com.anhkiet.cdio4_api.service.HouseService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class HouseController(
    private val houseService: HouseService
) {
    @GetMapping("/house")
    fun getHouseById(id: Int) = response {
        val house = houseService.getHouseById(id)
        content(
            HouseResponseModel(
                house != null,
                house
            )
        )
    }
}