package com.anhkiet.cdio4_api.repositories

import com.anhkiet.cdio4_api.entities.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<Category, Int>
