package com.example.cachorros.models

import com.example.cachorros.models.local.entities.CachorrosEnti
import com.example.cachorros.models.local.entities.FavoritosEnti
import com.example.cachorros.models.local.entities.SelectoEnti
import com.example.cachorros.models.remote.classApi.CachorrosClass

fun fromInternetToCachorrosEnti(cachorrosList: List<CachorrosClass>):List<CachorrosEnti>{
    return cachorrosList.map {
        CachorrosEnti(
            link = it.link
        )
    }

}

fun fromInternetToSelectoEnti(selectoList: List<CachorrosClass>):List<SelectoEnti>{
    return selectoList.map {
        SelectoEnti(
            link = it.link
        )
    }
}

fun fromSelectoToFavorito(selecto:SelectoEnti):FavoritosEnti{
    return FavoritosEnti(
        link = selecto.link
    )
}