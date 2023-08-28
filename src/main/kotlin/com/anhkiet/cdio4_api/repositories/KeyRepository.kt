package com.anhkiet.cdio4_api.repositories

import com.anhkiet.cdio4_api.entities.Key
import org.springframework.data.jpa.repository.JpaRepository

interface KeyRepository : JpaRepository<Key, Int>
