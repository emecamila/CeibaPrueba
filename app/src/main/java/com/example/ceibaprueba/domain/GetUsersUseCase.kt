package com.example.ceibaprueba.domain

import com.example.ceibaprueba.data.db.entities.toDatabase
import com.example.ceibaprueba.data.repository.UserRepository
import com.example.ceibaprueba.domain.model.User
import javax.inject.Inject

open class GetUsersUseCase @Inject constructor(private val repository: UserRepository) {

    suspend operator fun invoke(): List<User> {
        var users = repository.getAllUsersFromDb()
        return users.ifEmpty {
            users = repository.getAllUsersFromApi()
            repository.clearUsers()
            repository.insertAll(users.map { it.toDatabase() })
            users
        }

    }
}