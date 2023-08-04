package com.example.cachorros.models.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cachorros.models.local.cachorrosDAO
import com.example.cachorros.models.local.entities.CachorrosEnti
import com.example.cachorros.models.local.entities.FavoritosEnti
import com.example.cachorros.models.local.entities.SelectoEnti

@Database(entities = [CachorrosEnti::class, SelectoEnti::class, FavoritosEnti::class], version = 1,
    exportSchema = false)
abstract class cachorrosDB : RoomDatabase(){

    abstract fun getCachorrosDao() : cachorrosDAO

    companion object{

        @Volatile
        private var
                INSTANCE : cachorrosDB? = null
        fun getDataBase(context: Context) : cachorrosDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    cachorrosDB::class.java, "cachorros_db")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}