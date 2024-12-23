package com.example.maybellinehiltmvvmflow31_05_2024.network

import com.example.maybellinehiltmvvmflow31_05_2024.model.MyblineData
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    //http://makeup-api.herokuapp.com/api/v1/products.json?brand=maybelline

  /*  @GET("api/v1/products.json?brand=maybelline")
    fun getMyblineData():List<MyblineData>*/

    @GET("api/v1/products.json")
    suspend fun getMyblineData(@Query("brand") brand :String):List<MyblineData>

//https://<DOMAIN>/api/users?page=2&per_page=10
/*@GET("/api/users")
open fun getUsers(
    @Query("per_page") pageSize: Int,
    @Query("page") currentPage: Int
): Call<UsersApiResponse?>?*/


}