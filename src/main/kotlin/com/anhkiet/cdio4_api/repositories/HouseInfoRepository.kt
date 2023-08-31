package com.anhkiet.cdio4_api.repositories

import com.anhkiet.cdio4_api.entities.HouseInfo
import org.springframework.data.jpa.repository.JpaRepository


interface HouseInfoRepository : JpaRepository<HouseInfo, Int>
