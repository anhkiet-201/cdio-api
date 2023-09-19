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

        val address: AddressDTO? = null,

        val account: AccountDTO? = null,

        val project: ProjectDTO? = null,

        val info: HouseInfoDTO? = null
) {
    var createTime: BigDecimal = BigDecimal(Date().time)

    var isOwner: Boolean = false

    var isFavorite: Boolean = false

    constructor(house: House) : this(
            houseId = house.houseId,
            displayName = house.displayName,
            description = house.description,
            address = house.address?.let { AddressDTO(it) },
            account = house.email?.let { AccountDTO(it) },
            project = house.project?.let { ProjectDTO(it) },
            info = house.infor?.let { HouseInfoDTO(it) }
    ) {
        createTime = house.createTime ?: BigDecimal(0)
    }

    constructor(house: House, isOwner: Boolean, isFavorite: Boolean) : this(house) {
        this.isOwner = isOwner
        this.isFavorite = isFavorite
    }

    fun toEntity(): House {
        val house = House()
        house.houseId = houseId
        house.displayName = displayName
        house.description = description
//        house.address = address
        house.email = account?.toEntity()
        house.project = project?.toEntity()
        house.infor = info?.toEntity()
        house.createTime = createTime
        return house
    }

}