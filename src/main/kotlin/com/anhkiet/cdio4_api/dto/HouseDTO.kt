package com.anhkiet.cdio4_api.dto

import com.anhkiet.cdio4_api.entities.Account
import com.anhkiet.cdio4_api.entities.House
import com.anhkiet.cdio4_api.entities.Project
import com.fasterxml.jackson.annotation.JsonIgnore
import java.math.BigDecimal
import java.util.*

data class HouseDTO(
        val houseId: Int,

        val displayName: String,

        val description: String? = null,

        val address: String? = null,

        val account: Account? = null,

        @JsonIgnore
        val favoriteAccounts: List<Account> = emptyList(),

        val project: Project? = null,

        val category: CategoryDTO? = null,

        val info: HouseInfoDTO? = null
) {
    var createTime: BigDecimal = BigDecimal(Date().time)

    constructor(house: House) : this(
            houseId = house.houseId,
            displayName = house.displayName,
            description = house.description,
            address = house.address,
            account = house.email,
            favoriteAccounts = house.favoriteAccounts?.toList() ?: emptyList(),
            project = house.project,
            category = if (house.category != null) CategoryDTO(house.category!!) else null,
            info = if (house.infor != null) HouseInfoDTO(house.infor!!) else null
    ) {
        createTime = house.createTime ?: BigDecimal(0)
    }

    fun toEntity(): House {
        val house = House()
        house.houseId = houseId
        house.displayName = displayName
        house.description = description
        house.address = address
        house.email = account
        house.favoriteAccounts = favoriteAccounts.toMutableSet()
        house.project = project
        house.category = category?.toEntity()
        house.infor = info?.toEntity()
        house.createTime = createTime
        return house
    }

}