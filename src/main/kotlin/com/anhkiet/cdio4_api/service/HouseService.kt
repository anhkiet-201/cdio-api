package com.anhkiet.cdio4_api.service

import com.anhkiet.cdio4_api.dto.HouseDTO
import com.anhkiet.cdio4_api.repositories.HouseRepository
import org.springframework.stereotype.Service

@Service
class HouseService(
    val repo: HouseRepository
) {
    fun getNewestHouse(limit: Int = 3): List<HouseDTO> = repo.findAll().let {
        if (it.count() < 3) it else it.subList(0, 2)
    }.map {
        HouseDTO(it)
    }.toList()
}