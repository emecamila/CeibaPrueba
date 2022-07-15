package com.example.ceibaprueba.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ceibaprueba.data.db.dao.PostDao
import com.example.ceibaprueba.data.db.dao.UserDao
import com.example.ceibaprueba.data.db.dao.UserPostsDao
import com.example.ceibaprueba.data.db.entities.*

@Database(
    entities = [UserEntity::class, PostEntity::class],
    version = 2
)
abstract class UsersDb : RoomDatabase(){

    abstract fun getUserDao(): UserDao
    abstract fun getPostDao(): PostDao
    abstract fun getUserPostsDao(): UserPostsDao
}