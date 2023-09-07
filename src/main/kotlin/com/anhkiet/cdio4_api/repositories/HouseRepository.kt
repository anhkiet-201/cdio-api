package com.anhkiet.cdio4_api.repositories

import com.anhkiet.cdio4_api.entities.House
import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.domain.Pageable


interface HouseRepository : JpaRepository<House, Int> {
    fun searchAllByDisplayNameContainsIgnoreCaseOrAddressContainsIgnoreCase(displayName: String, address: String, pageable: Pageable): Page<House>
}
