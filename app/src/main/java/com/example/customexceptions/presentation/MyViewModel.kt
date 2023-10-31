package com.example.customexceptions.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.customexceptions.domain.CustomException
import com.example.customexceptions.domain.model.Category
import com.example.customexceptions.domain.usecase.FetchData
import com.example.customexceptions.domain.NetworkResult
import kotlinx.coroutines.launch

class MyViewModel(private val fetchData: FetchData):ViewModel() {
    private val _categories = MutableLiveData<List<Category>>()
    val categories: LiveData<List<Category>> = _categories
    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error
    fun getCategories() {
        viewModelScope.launch {
            when (val result = fetchData.execute()) {
                is NetworkResult.Success -> result.data?.let { _categories.postValue(it) }
                is NetworkResult.Error -> handleError(result.exception)
            }
        }
    }
    private fun handleError(exception: CustomException) { _error.postValue(exception.message) }
}
