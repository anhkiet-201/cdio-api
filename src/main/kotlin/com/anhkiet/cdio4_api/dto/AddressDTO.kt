package com.anhkiet.cdio4_api.dto

import com.anhkiet.cdio4_api.entities.Address
import com.anhkiet.cdio4_api.entities.House
import com.fasterxml.jackson.annotation.JsonIgnore

data class AddressDTO(
    @JsonIgnore
    var id: Int = -1,

    var province: String = "",

    var district: String = "",

    var wards: String = "",

    var street: String = "",

    var description: String? = null,

    @JsonIgnore
    var addressHouses: MutableSet<House>? = null,
) {
    constructor(address: Address) : this(
        address.id,
        address.province,
        address.district,
        address.wards,
        address.street,
        address.description,
        address.addressHouses,
    )
}
