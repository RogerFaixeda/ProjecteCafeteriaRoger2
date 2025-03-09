package com.faixeda.projectecafeteriaroger2.home.beguda

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.faixeda.projectecafeteriaroger2.R
import com.faixeda.projectecafeteriaroger2.databinding.BegudaFragmentBinding
import com.faixeda.projectecafeteriaroger2.databinding.MenjarFragmentBinding
import com.faixeda.projectecafeteriaroger2.home.CustomAdapter
import com.faixeda.projectecafeteriaroger2.home.SharedViewModel
import com.faixeda.projectecafeteriaroger2.home.menjar.MenjarViewModel

class BegudaFragment : Fragment() {
    private lateinit var binding: BegudaFragmentBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val viewModel: BegudaViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BegudaFragmentBinding.inflate(inflater)

        //RecyclerView
        val recyclerview = binding.recyclerview

        recyclerview.layoutManager = LinearLayoutManager(this.activity)

        viewModel.generarProductes()
        val begudes = viewModel.begudes

        val adapterRecycler = CustomAdapter(begudes) { menuModel ->

            sharedViewModel.afegirAlMenu(menuModel)

        }
        recyclerview.adapter = adapterRecycler


        return binding.root
    }
}