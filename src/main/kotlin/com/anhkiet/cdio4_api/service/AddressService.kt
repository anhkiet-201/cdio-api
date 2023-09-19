package com.anhkiet.cdio4_api.service

import com.anhkiet.cdio4_api.dto.AddressDTO
import com.anhkiet.cdio4_api.repositories.AddressRepository
import org.springframework.stereotype.Service

@Service
class AddressService(
    private val repo: AddressRepository
) {
    fun getAll(): List<AddressDTO> = repo.findAll().map { AddressDTO(it) }
}