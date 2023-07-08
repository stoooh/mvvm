package com.example.checkpoint3.fragments.dogs.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.checkpoint3.databinding.FragmentDogsBinding
import com.example.checkpoint3.fragments.dogs.domain.Dogs

class DogsFragment : Fragment() {

    private var _binding: FragmentDogsBinding? = null

    private val viewModel: DogsViewModel by viewModels{ DogsViewModelFactory() }
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDogsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.button.setOnClickListener {

            viewModel.dogsLiveData.observe(viewLifecycleOwner) {
                if (it != null) {
                    showBreeds(it)
                }
            }
            viewModel.getDogs()
        }
        return root
    }

    private fun showBreeds(dogs: Dogs){
        binding.textHome.text = dogs.breeds
        binding.image.load(dogs.img)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}