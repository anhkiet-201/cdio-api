package com.anhkiet.cdio4_api.repositories

import com.anhkiet.cdio4_api.entities.TinTuc
import org.springframework.data.jpa.repository.JpaRepository

interface TinTucRepository : JpaRepository<TinTuc, Int>
