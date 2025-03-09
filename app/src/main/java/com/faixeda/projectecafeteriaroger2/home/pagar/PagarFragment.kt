package com.faixeda.projectecafeteriaroger2.home.pagar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.faixeda.projectecafeteriaroger2.R
import com.faixeda.projectecafeteriaroger2.databinding.MenjarFragmentBinding
import com.faixeda.projectecafeteriaroger2.databinding.PagarFragmentBinding
import com.faixeda.projectecafeteriaroger2.home.SharedViewModel
import com.faixeda.projectecafeteriaroger2.home.menjar.MenjarViewModel

class PagarFragment : Fragment() {
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val viewModel: MenjarViewModel by viewModels()
    private lateinit var binding: PagarFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PagarFragmentBinding.inflate(inflater)

        sharedViewModel.preuTotalMenjar.observe(viewLifecycleOwner) { preu ->
            binding.textViewMenjarPreu.text = preu.toString()
        }

        sharedViewModel.preuTotalBeguda.observe(viewLifecycleOwner) { preu ->
            binding.textViewBegudaPreu.text = preu.toString()
        }

        sharedViewModel.preuTotalPostres.observe(viewLifecycleOwner) { preu ->
            binding.textViewPostrePreu.text = preu.toString()
        }

        sharedViewModel.preuTotal.observe(viewLifecycleOwner) { preu ->
            binding.textViewTotalPreu.text = preu.toString()
        }
        binding.buttonPagar.setOnClickListener {
            sharedViewModel.comprar()
        }
        // Inflate the layout for this fragment
        return binding.root
    }
}