package com.example.customexceptions.domain.usecase

import com.example.customexceptions.domain.model.Category
import com.example.customexceptions.domain.NetworkResult

class FetchData(private val dataRepository: DataRepository) {

    suspend fun execute(): NetworkResult<List<Category>> {
        return dataRepository.getCategories()
    }
}
