package com.anhkiet.cdio4_api.repositories

import com.anhkiet.cdio4_api.entities.ImageHouse
import org.springframework.data.jpa.repository.JpaRepository

interface ImageHouseRepository : JpaRepository<ImageHouse, Int>
