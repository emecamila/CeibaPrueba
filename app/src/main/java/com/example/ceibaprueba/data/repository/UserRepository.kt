package com.example.ceibaprueba.data.repository

import com.example.ceibaprueba.data.db.dao.UserDao
import com.example.ceibaprueba.data.db.entities.UserEntity
import com.example.ceibaprueba.data.network.UserService
import com.example.ceibaprueba.domain.model.User
import com.example.ceibaprueba.domain.model.toDomain
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val api: UserService,
    private val userDao: UserDao
) {

    suspend fun getAllUsersFromApi(): List<User> {
        val response = api.getUsers()
        return response.map { it.toDomain() }
    }

    suspend fun getAllUsersFromDb(): List<User> {
        val response = userDao.getAllUsers()
        return response.map { it.toDomain() }
    }

    suspend fun clearUsers(){
        userDao.deleteAll()
    }
    suspend fun insertAll(users:List<UserEntity>){
        userDao.insertAll(users)
    }

}