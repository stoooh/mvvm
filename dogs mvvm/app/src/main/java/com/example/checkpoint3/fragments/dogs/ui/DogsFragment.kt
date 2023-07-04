package com.example.checkpoint3.fragments.dogs.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.checkpoint3.databinding.FragmentDogsBinding
import com.example.checkpoint3.fragments.dogs.data.DogsRemote
import com.example.checkpoint3.fragments.dogs.domain.Dogs

class DogsFragment : Fragment() {

    private var _binding: FragmentDogsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel = ViewModelProvider(this)[DogsViewModel::class.java]
        DogsViewModelFactory()

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

    private fun showBreeds(breeds: List<Dogs>){
        binding.textHome.text = breeds.breeds
        binding.image.load(breeds.img)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}