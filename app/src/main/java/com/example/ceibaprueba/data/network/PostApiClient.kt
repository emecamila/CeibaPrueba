package com.example.ceibaprueba.data.network

import com.example.ceibaprueba.data.model.PostModel
import com.example.ceibaprueba.data.model.UserModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PostApiClient {

    @GET("posts")
    suspend fun getAllPosts(): Response<List<PostModel>>

    @GET("posts")
    suspend fun getAllPostsByUser(@Query("userId") userId:Long): Response<List<PostModel>>

}