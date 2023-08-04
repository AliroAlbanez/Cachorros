package com.example.cachorros.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cachorros.databinding.ModeloBinding
import com.example.cachorros.databinding.ModeloFavoritoBinding
import com.example.cachorros.models.local.entities.CachorrosEnti
import com.example.cachorros.models.local.entities.FavoritosEnti

class FavoritosAdapter : RecyclerView.Adapter<FavoritosAdapter.FavoritosViewHolder>() {

    private var listFavoritos = listOf<FavoritosEnti>()
    private val SelectedFavoritos = MutableLiveData<FavoritosEnti>()



    fun update(list:List<FavoritosEnti>){
        listFavoritos= list
        notifyDataSetChanged()
    }


    // FUNCION PARA SELECCIONAR

    fun selectedFavoritos():
            LiveData<FavoritosEnti> = SelectedFavoritos


    inner class  FavoritosViewHolder(private val mBinding: ModeloFavoritoBinding):
        RecyclerView.ViewHolder(mBinding.root), View.OnClickListener{

        fun bind(item: FavoritosEnti){
            val raza=item.link.substringAfterLast("/").replace("-","/")

            mBinding.textView2.text=raza
            Glide.with(itemView)
                .load(item.link)
                .into(mBinding.imageView)
            itemView.setOnClickListener(this)

        }
        override  fun onClick(v: View){

            SelectedFavoritos.value= listFavoritos[adapterPosition]
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritosViewHolder {
        return FavoritosViewHolder(ModeloFavoritoBinding.inflate(LayoutInflater.from(parent.context)))
    }


    override fun onBindViewHolder(holder: FavoritosViewHolder, position: Int) {
        val shoes = listFavoritos[position]
        holder.bind(shoes)
    }


    override fun getItemCount()=
        listFavoritos.size
}