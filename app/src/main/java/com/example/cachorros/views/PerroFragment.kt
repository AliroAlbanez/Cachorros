package com.example.cachorros.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cachorros.R
import com.example.cachorros.databinding.FragmentPerroBinding
import com.example.cachorros.databinding.FragmentRazasBinding
import com.example.cachorros.models.local.entities.SelectoEnti
import com.example.cachorros.views.adapters.PerroAdapter
import com.example.cachorros.views.adapters.RazasAdapter
import com.example.cachorros.views.viewModel.cachorrosViewModel

class PerroFragment : Fragment() {
    lateinit var perroBinding: FragmentPerroBinding
    private val perroViewModel: cachorrosViewModel by activityViewModels()
    private  var id:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        perroBinding= FragmentPerroBinding.inflate(inflater,container,false)
        arguments?.let { bundle ->

            id = bundle.getString("link").toString()

        }

        id?.let { id ->
            perroViewModel.getSelecto(id)
        }

        return perroBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter= PerroAdapter()
        perroBinding.recyclerPerro.adapter=adapter
        perroBinding.recyclerPerro.layoutManager= GridLayoutManager(context,2)
        perroViewModel.getSelectoList().observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.update(it)
            }
        })

        adapter.selectedPerro().observe(viewLifecycleOwner, Observer {

            it?.let {

            }
            val bundle:SelectoEnti= SelectoEnti(it.link)

            perroViewModel.insertFavorito(bundle)
        })

    }

}