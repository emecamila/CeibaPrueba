package com.example.ceibaprueba.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.ceibaprueba.data.db.entities.UserEntity
import javax.inject.Inject

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    suspend fun getAllUsers():List<UserEntity>

    @Insert
    suspend fun insertAll(userEntity: List<UserEntity>)

    @Query("DELETE FROM user")
    suspend fun deleteAll()

}