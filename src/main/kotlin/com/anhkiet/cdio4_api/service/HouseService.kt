package com.anhkiet.cdio4_api.service

import com.anhkiet.cdio4_api.dto.HouseDTO
import com.anhkiet.cdio4_api.model.SearchModel
import com.anhkiet.cdio4_api.repositories.HouseRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class HouseService(
        val repo: HouseRepository
) {
    fun getNewestHouse(limit: Int = 3): List<HouseDTO> = repo.findAll().let {
        if (it.count() < 3) it else it.subList(0, 2)
    }.map {
        HouseDTO(it)
    }.toList()

    fun search(searchModel: SearchModel): Page<HouseDTO> {
        val sort = Sort.by("displayName")
        val pageRequest = PageRequest.of(searchModel.index, searchModel.size, if (searchModel.sortByDesc) sort.descending() else sort.ascending())
        return repo.searchAllByDisplayNameContainsIgnoreCaseOrAddressContainsIgnoreCase(searchModel.key, searchModel.key, pageRequest)
                .map {
                    HouseDTO(it)
                }
    }
}