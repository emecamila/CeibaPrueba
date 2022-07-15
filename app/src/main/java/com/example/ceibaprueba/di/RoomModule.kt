package com.example.ceibaprueba.di

import android.content.Context
import androidx.room.Room
import com.example.ceibaprueba.data.db.UsersDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val USERS_DB_NAME = "users_db"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, UsersDb::class.java, USERS_DB_NAME).build()

    @Singleton
    @Provides
    fun provideUserDao(db:UsersDb)= db.getUserDao()

    @Singleton
    @Provides
    fun providePostDao(db:UsersDb)= db.getPostDao()

    @Singleton
    @Provides
    fun provideUserPostsDao(db:UsersDb)= db.getUserPostsDao()

}