package com.example.maybellinehiltmvvmflow31_05_2024.utils

import com.example.maybellinehiltmvvmflow31_05_2024.model.MyblineData


sealed class ApiState {
    object Loading :ApiState()

    class Failure(val msg:Throwable):ApiState()
    class Success(val data:List<MyblineData>):ApiState()
    object Empty:ApiState()
}