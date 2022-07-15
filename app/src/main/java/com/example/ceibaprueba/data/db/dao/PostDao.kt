package com.example.ceibaprueba.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.ceibaprueba.data.db.entities.PostEntity
import com.example.ceibaprueba.data.db.entities.UserEntity

@Dao
interface PostDao {

    @Query("SELECT * FROM post")
    suspend fun getAllPost():List<PostEntity>

    @Query("SELECT * FROM post WHERE userId=:id")
    suspend fun getAPostByUser(id:Long):List<PostEntity>

    @Insert
    suspend fun insertAll(postEntity: List<PostEntity>)

    @Query("DELETE FROM post")
    suspend fun deleteAll()

}