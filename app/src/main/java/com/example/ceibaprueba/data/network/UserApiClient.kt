package com.example.ceibaprueba.data.network

import com.example.ceibaprueba.data.model.UserModel
import retrofit2.Response
import retrofit2.http.GET

interface UserApiClient {

    @GET("users")
    suspend fun getAllUsers(): Response<List<UserModel>>
}