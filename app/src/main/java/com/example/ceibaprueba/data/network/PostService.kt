package com.example.ceibaprueba.data.network

import com.example.ceibaprueba.data.model.PostModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PostService @Inject constructor(private val api: PostApiClient) {

    suspend fun getPosts(): List<PostModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllPosts()
            response.body() ?: emptyList()
        }
    }

    suspend fun getPostsByUser(id:Long): List<PostModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllPostsByUser(id)
            response.body() ?: emptyList()
        }
    }

}