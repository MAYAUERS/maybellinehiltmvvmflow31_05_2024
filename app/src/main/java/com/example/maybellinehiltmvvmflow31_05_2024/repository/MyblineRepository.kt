package com.example.maybellinehiltmvvmflow31_05_2024.repository

import com.example.maybellinehiltmvvmflow31_05_2024.model.MyblineData
import com.example.maybellinehiltmvvmflow31_05_2024.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MyblineRepository @Inject constructor(private var apiService: ApiService) {

    fun getMyblineData():Flow<List<MyblineData>> = flow {
        val result = apiService.getMyblineData("maybelline")
        emit(result)
    }.flowOn(Dispatchers.IO)

  /*  fun getMyblineData():Flow<Result<List<MyblineData>>> = flow {
        val result = apiService.getMyblineData()
        emit(Result.success(result))
    }.flowOn(Dispatchers.IO)*/
}