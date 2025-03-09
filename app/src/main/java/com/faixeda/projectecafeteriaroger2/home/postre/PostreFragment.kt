package com.faixeda.projectecafeteriaroger2.home.postre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.faixeda.projectecafeteriaroger2.R
import com.faixeda.projectecafeteriaroger2.databinding.BegudaFragmentBinding
import com.faixeda.projectecafeteriaroger2.databinding.PostreFragmentBinding
import com.faixeda.projectecafeteriaroger2.home.CustomAdapter
import com.faixeda.projectecafeteriaroger2.home.SharedViewModel
import com.faixeda.projectecafeteriaroger2.home.beguda.BegudaViewModel


class PostreFragment : Fragment() {
    private lateinit var binding: PostreFragmentBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val viewModel: PostreViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PostreFragmentBinding.inflate(inflater)

        //RecyclerView
        val recyclerview = binding.recyclerview

        recyclerview.layoutManager = LinearLayoutManager(this.activity)

        viewModel.generarProductes()
        val postres = viewModel.postres

        val adapterRecycler = CustomAdapter(postres) { menuModel ->
            sharedViewModel.afegirAlMenu(menuModel)
        }
        recyclerview.adapter = adapterRecycler

        // Inflate the layout for this fragment
        return binding.root
    }
}