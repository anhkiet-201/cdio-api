package com.anhkiet.cdio4_api.repositories

import com.anhkiet.cdio4_api.entities.HouseType
import org.springframework.data.jpa.repository.JpaRepository


interface HouseTypeRepository : JpaRepository<HouseType, Int>
