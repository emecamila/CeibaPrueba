package com.example.ceibaprueba.domain.model

import com.example.ceibaprueba.data.db.entities.PostEntity
import com.example.ceibaprueba.data.model.PostModel

data class Post(
    val userId: Long,
    val id: Long,
    val title: String,
    val body: String
)

fun PostModel.toDomain() = Post(id, idUser, title, body)
fun PostEntity.toDomain() = Post(userId, id, title, body)