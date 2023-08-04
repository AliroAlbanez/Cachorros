package com.example.cachorros.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cachorros.databinding.ModeloRazaBinding
import com.example.cachorros.models.local.entities.SelectoEnti

class PerroAdapter : RecyclerView.Adapter<PerroAdapter.PerroViewHolder>() {

    private var listPerro = listOf<SelectoEnti>()
    private val SelectedPerro = MutableLiveData<SelectoEnti>()



    fun update(list:List<SelectoEnti>){
        listPerro= list
        notifyDataSetChanged()
    }


    // FUNCION PARA SELECCIONAR

    fun selectedPerro():
            LiveData<SelectoEnti> = SelectedPerro


    inner class  PerroViewHolder(private val mBinding: ModeloRazaBinding):
        RecyclerView.ViewHolder(mBinding.root), View.OnLongClickListener{

        fun bind(item: SelectoEnti){

            Glide.with(itemView)
                .load(item.link)
                .into(mBinding.razaImage)
            itemView.setOnLongClickListener(this)

        }
        override  fun onLongClick(v: View):Boolean{

            SelectedPerro.value= listPerro[adapterPosition]
            return true
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PerroViewHolder {
        return PerroViewHolder(ModeloRazaBinding.inflate(LayoutInflater.from(parent.context)))
    }


    override fun onBindViewHolder(holder: PerroViewHolder, position: Int) {
        val shoes = listPerro[position]
        holder.bind(shoes)
    }


    override fun getItemCount()=
        listPerro.size
}