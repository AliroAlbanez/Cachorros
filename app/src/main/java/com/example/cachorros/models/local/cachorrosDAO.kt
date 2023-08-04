package com.example.cachorros.models.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cachorros.models.local.entities.CachorrosEnti
import com.example.cachorros.models.local.entities.FavoritosEnti
import com.example.cachorros.models.local.entities.SelectoEnti

@Dao
interface cachorrosDAO {

    //Razas
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCachorros(listCachorros: List<CachorrosEnti>)

    @Query("SELECT * FROM cachorros_table")
    fun getAllCachorros(): LiveData<List<CachorrosEnti>>


    //Selecto
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllSelecto(listSelecto: List<SelectoEnti>)

    @Query("SELECT * FROM selecto_table")
    fun getAllSelecto(): LiveData<List<SelectoEnti>>

    @Query("DELETE FROM selecto_table")
    fun deleteAllSelecto()

    //Favoritos
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoritos(favoritos: FavoritosEnti)


    @Query("SELECT * FROM favoritos_table")
    fun getAllFavoritos(): LiveData<List<FavoritosEnti>>

    @Query("DELETE FROM favoritos_table")
    fun deleteAllFavoritos()

    @Query("DELETE FROM favoritos_table WHERE link=:id")
    fun deleteFavorito(id:String)
}