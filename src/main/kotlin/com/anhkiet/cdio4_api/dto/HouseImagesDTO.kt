package com.anhkiet.cdio4_api.dto

import com.anhkiet.cdio4_api.entities.HouseImages
import com.anhkiet.cdio4_api.entities.HouseInfo
import com.fasterxml.jackson.annotation.JsonIgnore

data class HouseImagesDTO(
    var houseImageId: Int,

    var imageUrl: String,

    @JsonIgnore
    var houseImageHouseInfos: List<HouseInfo> = emptyList()
) {
    constructor(houseImages: HouseImages) : this(
        houseImageId = houseImages.houseImageId,
        imageUrl = houseImages.imageUrl,
        houseImageHouseInfos = houseImages.houseImageHouseInfos?.toList() ?: emptyList()
    )

    fun toEntity(): HouseImages {
        val houseImages = HouseImages()
        houseImages.houseImageId = houseImageId
        houseImages.imageUrl = imageUrl
        houseImages.houseImageHouseInfos = houseImageHouseInfos.toMutableSet()
        return houseImages
    }
}
