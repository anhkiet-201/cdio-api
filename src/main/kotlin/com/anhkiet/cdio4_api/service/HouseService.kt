package com.anhkiet.cdio4_api.service

import com.anhkiet.cdio4_api.dto.HouseDTO
import com.anhkiet.cdio4_api.entities.House
import com.anhkiet.cdio4_api.model.PageableRequestModel
import com.anhkiet.cdio4_api.model.SearchModel
import com.anhkiet.cdio4_api.repositories.HouseRepository
import com.anhkiet.cdio4_api.utils.entension.toNullSafe
import com.anhkiet.cdio4_api.utils.heplper.RequestHelper
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class HouseService(
    val repo: HouseRepository,
    val requestHelper: RequestHelper
) {
    fun getAll(request: PageableRequestModel): Page<HouseDTO> {
        val sort = Sort.by("createTime")
        val pageRequest = PageRequest.of(
            request.index,
            request.size,
            sort.descending()
        )
        return repo.findAll(
            if (request.enableSort) pageRequest.withSort(sort) else pageRequest
        ).map { HouseDTO(it) }
    }

    fun search(searchModel: SearchModel): Page<HouseDTO> {
        val sort = Sort.by("displayName")
        val pageRequest = PageRequest.of(
            searchModel.index,
            searchModel.size,
            if (searchModel.sortByDesc) sort.descending() else sort.ascending()
        )
        return repo.searchAllByDisplayNameContainsIgnoreCaseAndAddressProvinceContainsIgnoreCaseAndAddressDistrictContainsIgnoreCaseAndAddressWardsContainsIgnoreCaseAndAddressStreetContainsIgnoreCaseAndProjectProjectNameContainsIgnoreCase(
            searchModel.key,
            searchModel.province ?: "",
            searchModel.district ?: "",
            searchModel.wards ?: "",
            searchModel.street ?: "",
            searchModel.projectName ?: "",
            pageRequest
        )
            .map {
                HouseDTO(it, isOwner(it), isFavorite(it))
            }
    }

    fun getHouseById(id: Int): HouseDTO? = repo.findById(id).toNullSafe().let {
        if (it != null)
            HouseDTO(it, isOwner(it), isFavorite(it))
        else
            null
    }

    private fun isOwner(house: House?): Boolean {
        val account = requestHelper.getCurrentUserRequest()
        if (house?.email?.email == null || account == null) return false
        return house.email?.let {
            (it.email ?: "") == account.email
        } ?: false
    }

    private fun isFavorite(house: House?): Boolean {
        val account = requestHelper.getCurrentUserRequest()
        if (house?.email?.favoriteHouses == null || account == null) return false
        return house.favoriteAccounts?.let {
            it.map { it.email ?: "" }.contains(account.email)
        } ?: false
    }
}