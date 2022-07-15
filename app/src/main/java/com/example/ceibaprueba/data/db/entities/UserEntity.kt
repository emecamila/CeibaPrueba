package com.example.ceibaprueba.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ceibaprueba.data.model.UserAddress
import com.example.ceibaprueba.data.model.UserCompany
import com.example.ceibaprueba.domain.model.User

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey
    val id: Long,
    val name: String?,
    val username: String?,
    val email: String?,
    val phone: String?,
    val website: String?
)
fun User.toDatabase() = UserEntity(
    id,
    name,
    username,
    email,
    phone,
    website
)
