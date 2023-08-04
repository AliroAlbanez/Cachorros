package com.example.cachorros.models.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favoritos_table")
data class FavoritosEnti (
    @PrimaryKey
    @ColumnInfo(name="link")
    val link:String
)