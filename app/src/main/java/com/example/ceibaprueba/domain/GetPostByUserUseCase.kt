package com.example.ceibaprueba.domain

import com.example.ceibaprueba.data.db.entities.toDatabase
import com.example.ceibaprueba.data.repository.PostRepository
import com.example.ceibaprueba.domain.model.Post
import javax.inject.Inject

class GetPostByUserUseCase @Inject constructor(private val repository: PostRepository) {

    suspend operator fun invoke(id:Long): List<Post> {
        var posts = repository.getAllPostByUserFromDb(id)
        return posts.ifEmpty {
            posts = repository.getAllPostByUserFromApi(id)
            repository.clearPosts()
            repository.insertAll(posts.map { it.toDatabase() })
            posts
        }
    }
}