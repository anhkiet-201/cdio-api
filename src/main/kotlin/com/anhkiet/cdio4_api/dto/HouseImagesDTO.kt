package com.anhkiet.cdio4_api.dto

import com.anhkiet.cdio4_api.entities.HouseImages
import com.fasterxml.jackson.annotation.JsonIgnore

data class HouseImagesDTO(
    @JsonIgnore
    var houseImageId: Int,

    var imageUrl: String,
) {
    constructor(houseImages: HouseImages) : this(
        houseImageId = houseImages.houseImageId ?: -1,
        imageUrl = houseImages.imageUrl,
    )

    fun toEntity(): HouseImages {
        val houseImages = HouseImages()
        houseImages.houseImageId = houseImageId
        houseImages.imageUrl = imageUrl
        return houseImages
    }
}
