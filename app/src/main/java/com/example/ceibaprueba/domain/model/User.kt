package com.example.ceibaprueba.domain.model

import com.example.ceibaprueba.data.db.entities.UserEntity
import com.example.ceibaprueba.data.model.UserAddress
import com.example.ceibaprueba.data.model.UserCompany
import com.example.ceibaprueba.data.model.UserModel

data class User(
    val id: Long,
    val name: String?,
    val username: String?,
    val email: String?,
    val phone: String?,
    val website: String?,
)

fun UserModel.toDomain() = User(id, name, username, email, phone, website)
fun UserEntity.toDomain() = User(id, name, username, email, phone, website)
