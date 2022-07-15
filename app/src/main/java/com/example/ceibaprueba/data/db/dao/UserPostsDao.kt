package com.example.ceibaprueba.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.ceibaprueba.data.db.entities.UserEntity
import com.example.ceibaprueba.data.db.entities.UserPostsEntity

@Dao
interface UserPostsDao {

    @Transaction
    @Query("SELECT * FROM user")
    suspend fun getAllPostsUser():List<UserPostsEntity>
}