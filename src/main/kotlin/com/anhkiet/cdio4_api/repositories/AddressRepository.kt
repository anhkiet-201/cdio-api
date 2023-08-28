package com.anhkiet.cdio4_api.repositories


import com.anhkiet.cdio4_api.entities.Address
import org.springframework.data.jpa.repository.JpaRepository

interface AddressRepository : JpaRepository<Address, Int>
