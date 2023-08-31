package com.anhkiet.cdio4_api.repositories

import com.anhkiet.cdio4_api.entities.House
import org.springframework.data.jpa.repository.JpaRepository


interface HouseRepository : JpaRepository<House, Int>
