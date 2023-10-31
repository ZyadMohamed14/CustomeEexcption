package com.example.customexceptions.data

import com.example.customexceptions.domain.model.Category
import retrofit2.http.GET


interface ApiService {
    companion object{
        const val KEY_API="categories.php"
    }
    @GET(KEY_API)
    suspend fun getCategories(): List<Category>
}