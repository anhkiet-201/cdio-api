package com.anhkiet.cdio4_api.dto

import com.anhkiet.cdio4_api.entities.*
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

    val category: Category? = null,

    val info: HouseInfo? = null
) {
    var createTime: BigDecimal = BigDecimal(Date().time)

    constructor(house: House):this(
        houseId = house.houseId,
        displayName = house.displayName,
        description = house.description,
        address = house.address,
        account = house.email,
        favoriteAccounts = house.favoriteAccounts?.toList() ?: emptyList(),
        project = house.project,
        category = house.category,
        info = house.infor
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
        house.category = category
        house.infor = info
        house.createTime = createTime
        return house
    }

}