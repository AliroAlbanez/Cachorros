package com.example.cachorros.views.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.cachorros.models.CachorrosRepository
import com.example.cachorros.models.local.database.cachorrosDB
import com.example.cachorros.models.local.entities.CachorrosEnti
import com.example.cachorros.models.local.entities.FavoritosEnti
import com.example.cachorros.models.local.entities.SelectoEnti
import kotlinx.coroutines.launch

class cachorrosViewModel (application: Application): AndroidViewModel(application){
    val lista: List<String> = listOf(
        "affenpinscher",
        "african",
        "airedale",
        "akita",
        "appenzeller",
        "australian/shepherd",
        "basenji",
        "beagle",
        "bluetick",
        "borzoi",
        "bouvier",
        "boxer",
        "brabancon",
        "briard",
        "buhund/norwegian",
        "bulldog/boston",
        "bulldog/english",
        "bulldog/french",
        "bullterrier/staffordshire",
        "cattledog/australian",
        "chihuahua",
        "chow",
        "clumber",
        "cockapoo",
        "collie/border",
        "coonhound",
        "corgi/cardigan",
        "cotondetulear",
        "dachshund",
        "dalmatian",
        "dane/great",
        "deerhound/scottish",
        "dhole",
        "dingo",
        "doberman",
        "elkhound/norwegian",
        "entlebucher",
        "eskimo",
        "finnish/lapphund",
        "frise/bichon",
        "germanshepherd",
        "greyhound/italian",
        "groenendael",
        "havanese",
        "hound/afghan",
        "hound/basset",
        "hound/blood",
        "hound/english",
        "hound/ibizan",
        "hound/plott",
        "hound/walker",
        "husky",
        "keeshond",
        "kelpie",
        "komondor",
        "kuvasz",
        "labradoodle",
        "labrador",
        "leonberg",
        "lhasa",
        "malamute",
        "malinois",
        "maltese",
        "mastiff/bull",
        "mastiff/english",
        "mastiff/tibetan",
        "mexicanhairless",
        "mix",
        "mountain/bernese",
        "mountain/swiss",
        "newfoundland",
        "otterhound",
        "ovcharka/caucasian",
        "papillon",
        "pekinese",
        "pembroke",
        "pinscher/miniature",
        "pitbull",
        "pointer/german",
        "pointer/germanlonghair",
        "pomeranian",
        "poodle/medium",
        "poodle/miniature",
        "poodle/standard",
        "poodle/toy",
        "pug",
        "puggle",
        "pyrenees",
        "redbone",
        "retriever/chesapeake",
        "retriever/curly",
        "retriever/flatcoated",
        "retriever/golden",
        "ridgeback/rhodesian",
        "rottweiler",
        "saluki",
        "samoyed",
        "schipperke",
        "schnauzer/giant",
        "schnauzer/miniature",
        "segugio/italian",
        "setter/english",
        "setter/gordon",
        "setter/irish",
        "sharpei",
        "sheepdog/english",
        "sheepdog/shetland",
        "shiba",
        "shihtzu",
        "spaniel/blenheim",
        "spaniel/brittany",
        "spaniel/cocker",
        "spaniel/irish",
        "spaniel/japanese",
        "spaniel/sussex",
        "spaniel/welsh",
        "spitz/japanese",
        "springer/english",
        "stbernard",
        "terrier/american",
        "terrier/australian",
        "terrier/bedlington",
        "terrier/border",
        "terrier/cairn",
        "terrier/dandie",
        "terrier/fox",
        "terrier/irish",
        "terrier/kerryblue",
        "terrier/lakeland",
        "terrier/norfolk",
        "terrier/norwich",
        "terrier/patterdale",
        "terrier/russell",
        "terrier/scottish",
        "terrier/sealyham",
        "terrier/silky",
        "terrier/tibetan",
        "terrier/toy",
        "terrier/welsh",
        "terrier/westhighland",
        "terrier/wheaten",
        "terrier/yorkshire",
        "tervuren",
        "vizsla",
        "waterdog/spanish",
        "weimaraner",
        "whippet",
        "wolfhound/irish"
    )
    private val repository : CachorrosRepository

    init{
        val bd= cachorrosDB.getDataBase(application)
        val  cachorrosDao = bd.getCachorrosDao()

        repository = CachorrosRepository(cachorrosDao)

        for (i in 0 until lista.size){
            getCachorrosTodos(lista[i])
        }
    }
fun getCachorrosTodos(id:String)= viewModelScope.launch {

        repository.fechCachorros(id)
}

    fun getSelecto(id:String)=viewModelScope.launch {
        repository.fechSelecto(id)
    }


    fun getCachorrosList(): LiveData<List<CachorrosEnti>> = repository.cachorrosListLiveData


    fun getSelectoList(): LiveData<List<SelectoEnti>> = repository.selectoListLiveData

    fun getFavoritosList(): LiveData<List<FavoritosEnti>> = repository.faforitosListLiveData

    fun insertFavorito(id:SelectoEnti)=viewModelScope.launch {
        repository.fechFavorito(id)
    }

    fun removeFavorito(id:String)=viewModelScope.launch {
        repository.deleteFavorito(id)
    }

    fun removeAllFavoritos()=viewModelScope.launch {
        repository.deleteAllFavoritos()
    }
}