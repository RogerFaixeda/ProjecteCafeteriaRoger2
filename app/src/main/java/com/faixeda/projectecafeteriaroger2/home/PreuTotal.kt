package com.faixeda.projectecafeteriaroger2.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.faixeda.projectecafeteriaroger2.databinding.FragmentPreuTotalBinding


class PreuTotal : Fragment() {
    private lateinit var binding : FragmentPreuTotalBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPreuTotalBinding.inflate(inflater)


        sharedViewModel.preuTotal.observe(viewLifecycleOwner) { preu ->
            binding.textViewPreuTotal.text = preu.toString()
        }


        // Inflate the layout for this fragment
        return binding.root
    }
}