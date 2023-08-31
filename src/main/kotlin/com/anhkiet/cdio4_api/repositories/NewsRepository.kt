package com.anhkiet.cdio4_api.repositories

import com.anhkiet.cdio4_api.entities.News
import org.springframework.data.jpa.repository.JpaRepository


interface NewsRepository : JpaRepository<News, Int>
