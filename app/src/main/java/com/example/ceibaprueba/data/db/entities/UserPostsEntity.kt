package com.example.ceibaprueba.data.db.entities

import androidx.room.Embedded
import androidx.room.Relation
import com.example.ceibaprueba.data.model.UserModel

data class UserPostsEntity(
    @Embedded val user: UserEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "userId"
    )
    val posts: List<PostEntity>
)