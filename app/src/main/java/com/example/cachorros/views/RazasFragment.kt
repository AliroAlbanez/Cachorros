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
import com.example.cachorros.databinding.FragmentRazasBinding
import com.example.cachorros.views.adapters.RazasAdapter
import com.example.cachorros.views.viewModel.cachorrosViewModel


class RazasFragment : Fragment() {
    lateinit var razasBinding: FragmentRazasBinding
    lateinit var boton1: Button
    private val razaViewModel: cachorrosViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        razasBinding= FragmentRazasBinding.inflate(inflater,container,false)
        boton1=razasBinding.button

        boton1.setOnClickListener{
            findNavController().navigate(R.id.action_razasFragment_to_favoritosFragment)
        }
        return razasBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    val adapter=RazasAdapter()
        razasBinding.razasRecyclerView.adapter=adapter
        razasBinding.razasRecyclerView.layoutManager=GridLayoutManager(context,2)
        razaViewModel.getCachorrosList().observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.update(it)
            }
        })

        adapter.selectedRaza().observe(viewLifecycleOwner, Observer {

            it?.let {

            }
            val bundle=Bundle().apply {
                putString("raza",it.link.substringAfterLast("/").replace("-","/"))
                putString("link",it.link)
            }
            findNavController().navigate(R.id.action_razasFragment_to_perroFragment,bundle)
        })

    }

}