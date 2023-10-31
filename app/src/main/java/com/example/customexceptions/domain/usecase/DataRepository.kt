package com.example.customexceptions.domain.usecase

import com.example.customexceptions.domain.model.Category
import com.example.customexceptions.domain.NetworkResult

interface DataRepository {
    suspend fun getCategories(): NetworkResult<List<Category>>
}