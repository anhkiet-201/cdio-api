package com.anhkiet.cdio4_api.repositories

import com.anhkiet.cdio4_api.entities.House
import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.domain.Pageable


interface HouseRepository : JpaRepository<House, Int> {
    fun searchAllByAddress_ProvinceAndAddress_DistrictAndAddress_WardsAndAddress_StreetAndDisplayNameContainsIgnoreCaseAndProject_ProjectName(
        address_province: String?,
        address_district: String?,
        address_wards: String?,
        address_street: String?,
        displayName: String,
        project_projectName: String?,
        pageable: Pageable
    ): Page<House>
}
