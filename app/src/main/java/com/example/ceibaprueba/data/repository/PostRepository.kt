package com.example.ceibaprueba.data.repository

import com.example.ceibaprueba.data.db.dao.PostDao
import com.example.ceibaprueba.data.db.dao.UserPostsDao
import com.example.ceibaprueba.data.db.entities.PostEntity
import com.example.ceibaprueba.data.db.entities.UserEntity
import com.example.ceibaprueba.data.network.PostService
import com.example.ceibaprueba.domain.model.Post
import com.example.ceibaprueba.domain.model.User
import com.example.ceibaprueba.domain.model.toDomain
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val api: PostService,
    private val postDao: PostDao
) {

    suspend fun getAllPostFromApi(): List<Post> {
        val response = api.getPosts()
        return response.map { it.toDomain() }
    }

    suspend fun getAllPostFromDb(): List<Post> {
        val response = postDao.getAllPost()
        return response.map { it.toDomain() }
    }

    suspend fun getAllPostByUserFromApi(id:Long): List<Post> {
        val response = api.getPostsByUser(id)
        return response.map { it.toDomain() }
    }

    suspend fun getAllPostByUserFromDb(id:Long): List<Post> {
        val response =  postDao.getAPostByUser(id)
        return response.map { it.toDomain() }
    }

    suspend fun clearPosts(){
        postDao.deleteAll()
    }
    suspend fun insertAll(post:List<PostEntity>){
        postDao.insertAll(post)
    }
}