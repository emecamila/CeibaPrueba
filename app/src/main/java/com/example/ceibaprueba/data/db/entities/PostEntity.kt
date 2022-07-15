package com.example.ceibaprueba.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ceibaprueba.domain.model.Post

@Entity(tableName = "post")
data class PostEntity(
    @PrimaryKey(autoGenerate = true)
    val idPost: Long= 0,
    val id: Long,
    val userId: Long,
    val title: String,
    val body: String
)

fun Post.toDatabase() = PostEntity(id= id, userId = userId, title = title, body = body)
