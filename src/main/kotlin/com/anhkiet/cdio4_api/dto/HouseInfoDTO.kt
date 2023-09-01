package com.anhkiet.cdio4_api.dto

import com.anhkiet.cdio4_api.entities.HouseImages
import com.anhkiet.cdio4_api.entities.HouseInfo
import com.anhkiet.cdio4_api.entities.HouseType
import com.fasterxml.jackson.annotation.JsonIgnore

data class HouseInfoDTO(
    val infoId: Int,

    val thumbNailUrl: String? = null,

    val numKitchen: Int = 0,

    val numBathroom: Int = 0,

    val numToilet: Int = 0,

    val numLivingRoom: Int = 0,

    val numBedRoom: Int = 0,

    val houseImage: HouseImages? = null,

    @JsonIgnore
    val houseTypeDetailHouseTypes: List<HouseType> = emptyList(),
) {
    constructor(houseInfo: HouseInfo) : this(
        infoId = houseInfo.inforId,
        thumbNailUrl = houseInfo.thumbNailUrl,
        numKitchen = houseInfo.numKitchen ?: 0,
        numBathroom = houseInfo.numBathroom ?: 0,
        numToilet = houseInfo.numToilet ?: 0,
        numLivingRoom = houseInfo.numLivingRoom ?: 0,
        numBedRoom = houseInfo.numBedRoom ?: 0,
        houseImage = houseInfo.houseImage,
        houseTypeDetailHouseTypes = houseInfo.houseTypeDetailHouseTypes?.toList() ?: emptyList()
    )

    fun toEntity(): HouseInfo {
        val houseInfo = HouseInfo()
        houseInfo.inforId = infoId
        houseInfo.thumbNailUrl = thumbNailUrl
        houseInfo.numKitchen = numKitchen
        houseInfo.numBathroom = numBathroom
        houseInfo.numToilet = numToilet
        houseInfo.numLivingRoom = numLivingRoom
        houseInfo.numBedRoom = numBedRoom
        houseInfo.houseImage = houseImage
        houseInfo.houseTypeDetailHouseTypes = houseTypeDetailHouseTypes.toMutableSet()
        return houseInfo
    }
}
