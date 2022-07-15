package com.example.ceibaprueba.domain

import com.example.ceibaprueba.data.db.entities.toDatabase
import com.example.ceibaprueba.data.repository.PostRepository
import com.example.ceibaprueba.domain.model.Post
import javax.inject.Inject

class GetPostUseCase @Inject constructor(private val repository: PostRepository) {

    suspend operator fun invoke(): List<Post> {
        var posts = repository.getAllPostFromDb()

        return posts.ifEmpty {
            posts = repository.getAllPostFromApi()
            repository.clearPosts()
            repository.insertAll(posts.map { it.toDatabase() })
            posts
        }
    }
}