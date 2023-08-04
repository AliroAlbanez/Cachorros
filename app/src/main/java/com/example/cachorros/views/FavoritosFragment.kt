package com.example.cachorros.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cachorros.R
import com.example.cachorros.databinding.FragmentFavoritosBinding
import com.example.cachorros.databinding.FragmentRazasBinding
import com.example.cachorros.views.adapters.FavoritosAdapter
import com.example.cachorros.views.adapters.RazasAdapter
import com.example.cachorros.views.viewModel.cachorrosViewModel

class FavoritosFragment : Fragment() {
    lateinit var favoritosBinding: FragmentFavoritosBinding
    lateinit var boton:Button
    private val favoritosViewModel: cachorrosViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        favoritosBinding= FragmentFavoritosBinding.inflate(inflater,container,false)
        boton=favoritosBinding.buttonBorrar

        boton.setOnClickListener { favoritosViewModel.removeAllFavoritos()
        }
        return favoritosBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter= FavoritosAdapter()
        favoritosBinding.recyclerFavorito.adapter=adapter
        favoritosBinding.recyclerFavorito.layoutManager= GridLayoutManager(context,2)
        favoritosViewModel.getFavoritosList().observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.update(it)
            }
        })

        adapter.selectedFavoritos().observe(viewLifecycleOwner, Observer {

            it?.let {

            }
            favoritosViewModel.removeFavorito(it.link)
        })

    }

}