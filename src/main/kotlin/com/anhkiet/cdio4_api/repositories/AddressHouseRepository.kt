package com.anhkiet.cdio4_api.repositories

import com.anhkiet.cdio4_api.entities.AddressHouse
import org.springframework.data.jpa.repository.JpaRepository

interface AddressHouseRepository : JpaRepository<AddressHouse, Int>
