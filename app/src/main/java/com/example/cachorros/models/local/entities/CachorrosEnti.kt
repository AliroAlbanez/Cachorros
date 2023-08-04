package com.example.cachorros.models.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cachorros_table")
data class CachorrosEnti (
    @PrimaryKey
    @ColumnInfo(name="link")
    val link:String
)