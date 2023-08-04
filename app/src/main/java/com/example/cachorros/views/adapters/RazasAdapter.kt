package com.example.cachorros.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cachorros.databinding.ModeloBinding
import com.example.cachorros.models.local.entities.CachorrosEnti

class RazasAdapter : RecyclerView.Adapter<RazasAdapter.RazaViewHolder>() {

    private var listRazas = listOf<CachorrosEnti>()
    private val SelectedRaza = MutableLiveData<CachorrosEnti>()



    fun update(list:List<CachorrosEnti>){
        listRazas= list
        notifyDataSetChanged()
    }


    // FUNCION PARA SELECCIONAR

    fun selectedRaza():
            LiveData<CachorrosEnti> = SelectedRaza


    inner class  RazaViewHolder(private val mBinding: ModeloBinding):
        RecyclerView.ViewHolder(mBinding.root), View.OnClickListener{

        fun bind(item: CachorrosEnti){
            val raza=item.link.substringAfterLast("/").replace("-","/")

            mBinding.razatext.text=raza
            Glide.with(itemView)
                .load(item.link)
                .into(mBinding.imagenPerro)
            itemView.setOnClickListener(this)

        }
        override  fun onClick(v: View){

            SelectedRaza.value= listRazas[adapterPosition]
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RazaViewHolder {
        return RazaViewHolder(ModeloBinding.inflate(LayoutInflater.from(parent.context)))
    }


    override fun onBindViewHolder(holder: RazaViewHolder, position: Int) {
        val shoes = listRazas[position]
        holder.bind(shoes)
    }


    override fun getItemCount()=
        listRazas.size
}