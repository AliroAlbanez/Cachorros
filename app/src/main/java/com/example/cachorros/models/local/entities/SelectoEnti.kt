package com.example.cachorros.models.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "selecto_table")
data class SelectoEnti (
    @PrimaryKey
    @ColumnInfo(name="link")
    val link:String
)