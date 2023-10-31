package com.example.customexceptions.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.customexceptions.domain.usecase.DataRepository
import com.example.customexceptions.domain.usecase.FetchData

class MyViewModelFactory(private val dataRepository: DataRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MyViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MyViewModel(FetchData(dataRepository)) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
