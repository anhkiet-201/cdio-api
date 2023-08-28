package com.anhkiet.cdio4_api.repositories

import com.anhkiet.cdio4_api.entities.InfoHouse
import org.springframework.data.jpa.repository.JpaRepository

interface InfoHouseRepository : JpaRepository<InfoHouse, Int>
