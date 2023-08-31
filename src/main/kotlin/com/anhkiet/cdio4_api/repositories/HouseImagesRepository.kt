package com.anhkiet.cdio4_api.repositories

import com.anhkiet.cdio4_api.entities.HouseImages
import org.springframework.data.jpa.repository.JpaRepository


interface HouseImagesRepository : JpaRepository<HouseImages, Int>
