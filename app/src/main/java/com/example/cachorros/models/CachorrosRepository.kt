package com.example.cachorros.models

import android.util.Log
import com.example.cachorros.models.local.cachorrosDAO
import com.example.cachorros.models.local.entities.CachorrosEnti
import com.example.cachorros.models.local.entities.SelectoEnti
import com.example.cachorros.models.remote.RetrofitClient

class CachorrosRepository (private val cachorrosDao: cachorrosDAO){

    private val networkService = RetrofitClient.retrofitInstance()
    val cachorrosListLiveData = cachorrosDao.getAllCachorros()
    val selectoListLiveData = cachorrosDao.getAllSelecto()
    val faforitosListLiveData=cachorrosDao.getAllFavoritos()

    suspend fun  fechCachorros(id:String){

        val service = kotlin.runCatching { networkService.fechCachorros(id)}

        service.onSuccess {
            when(it.code()){
                in 200..299-> it.body()?.let {
                    cachorrosDao.insertAllCachorros(fromInternetToCachorrosEnti(it))
                }
                else -> Log.d("Repo", "${it.code()}-${it.errorBody()}")
            }
            service.onFailure {
                Log.e("Error","${it.message}")
            }
        }
    }

    suspend fun fechSelecto(id:String){
        cachorrosDao.deleteAllSelecto()
        val service =kotlin.runCatching { networkService.fechRaza(id) }
        service.onSuccess {
            when(it.code()){
                in 200..299-> it.body()?.let {
                    cachorrosDao.insertAllSelecto(fromInternetToSelectoEnti(it))
                }
                else -> Log.d("Repo", "${it.code()}-${it.errorBody()}")
            }
            service.onFailure {
                Log.e("Error","${it.message}")
            }
        }

    }

    suspend fun fechFavorito(id:SelectoEnti){
        cachorrosDao.insertFavoritos(fromSelectoToFavorito(id))
    }

    suspend fun deleteFavorito(id:String){
        cachorrosDao.deleteFavorito(id)
    }

    suspend fun deleteAllFavoritos(){
        cachorrosDao.deleteAllFavoritos()
    }
}