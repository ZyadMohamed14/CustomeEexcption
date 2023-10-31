package com.example.customexceptions.presentation

import com.example.customexceptions.data.DataRepositoryImpl
import com.example.customexceptions.domain.usecase.FetchData

class Container {
    val dataRepositoryImpl=DataRepositoryImpl()
    val fetchData= FetchData(dataRepositoryImpl)
    val loginViewModelFactory = MyViewModelFactory(dataRepositoryImpl)
}