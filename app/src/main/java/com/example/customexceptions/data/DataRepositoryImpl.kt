package com.example.customexceptions.data

import com.example.customexceptions.domain.CustomException
import com.example.customexceptions.domain.model.Category
import com.example.customexceptions.domain.usecase.DataRepository
import com.example.customexceptions.domain.ErrorCode
import com.example.customexceptions.domain.NetworkResult
import retrofit2.HttpException

class DataRepositoryImpl : DataRepository {
    override suspend fun getCategories(): NetworkResult<List<Category>> {
        return try {
            val response = RetrofitClient.apiService.getCategories()
            NetworkResult.Success(response)
        } catch (e: Exception) {
            when (e) {
                is HttpException -> {
                    when (e.code()) {
                        ErrorCode.NOT_FOUND.code -> NetworkResult.Error(CustomException.NotFoundException(e.message()))
                        ErrorCode.REQUEST_TIMEOUT.code -> NetworkResult.Error(CustomException.RequestTimeoutException(e.message()))
                        else -> NetworkResult.Error(CustomException.NetworkException(e.message()))
                    }
                }
                else -> NetworkResult.Error(CustomException.NetworkException(e.message.toString()))
            }
        }
    }
}
