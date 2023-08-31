package com.anhkiet.cdio4_api.dto

import com.anhkiet.cdio4_api.entities.HouseInfo
import com.anhkiet.cdio4_api.entities.HouseType
import com.fasterxml.jackson.annotation.JsonIgnore
import java.math.BigDecimal

data class HouseTypeDTO(
    val houseTypeId: Int,

    val typeName: String,

    val price: BigDecimal,

    @JsonIgnore
    val houseTypeDetailHouseInfos: List<HouseInfo> = emptyList()
) {
    constructor(houseType: HouseType) : this(
        houseTypeId = houseType.houseTypeId,
        typeName = houseType.typeName,
        price = houseType.price,
        houseTypeDetailHouseInfos = houseType.houseTypeDetailHouseInfos?.toList() ?: emptyList()
    )

    fun toEntity(): HouseType {
        val houseType = HouseType()
        houseType.houseTypeId = houseTypeId
        houseType.typeName = typeName
        houseType.price = price
        houseType.houseTypeDetailHouseInfos = houseTypeDetailHouseInfos.toMutableSet()
        return houseType
    }
}
