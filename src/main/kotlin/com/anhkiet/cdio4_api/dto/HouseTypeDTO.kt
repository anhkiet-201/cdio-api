package com.anhkiet.cdio4_api.dto

import com.anhkiet.cdio4_api.entities.HouseInfo
import com.anhkiet.cdio4_api.entities.HouseType
import com.fasterxml.jackson.annotation.JsonIgnore
import java.math.BigDecimal

data class HouseTypeDTO(
    @JsonIgnore
    val houseTypeId: Int,

    val typeName: String,

    val price: BigDecimal,
) {
    constructor(houseType: HouseType) : this(
        houseTypeId = houseType.houseTypeId,
        typeName = houseType.typeName,
        price = houseType.price,
    )

    fun toEntity(): HouseType {
        val houseType = HouseType()
        houseType.houseTypeId = houseTypeId
        houseType.typeName = typeName
        houseType.price = price
        return houseType
    }
}
