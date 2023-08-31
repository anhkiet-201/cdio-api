package com.anhkiet.cdio4_api.repositories

import com.anhkiet.cdio4_api.entities.Investor
import org.springframework.data.jpa.repository.JpaRepository


interface InvestorRepository : JpaRepository<Investor, Int>
