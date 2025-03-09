package com.faixeda.projectecafeteriaroger2.home.menjar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.faixeda.projectecafeteriaroger2.databinding.MenjarFragmentBinding
import com.faixeda.projectecafeteriaroger2.home.CustomAdapter
import com.faixeda.projectecafeteriaroger2.home.SharedViewModel

class MenjarFragment : Fragment() {
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val viewModel: MenjarViewModel by viewModels()
    private lateinit var binding: MenjarFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MenjarFragmentBinding.inflate(inflater)

        //RecyclerView
        val recyclerview = binding.recyclerview

        recyclerview.layoutManager = LinearLayoutManager(this.activity)

        viewModel.generarProductes()
        val menjars = viewModel.menjars

        val adapterRecycler = CustomAdapter(menjars) { menuModel ->

            sharedViewModel.afegirAlMenu(menuModel)

        }
        recyclerview.adapter = adapterRecycler

        return binding.root
    }
}