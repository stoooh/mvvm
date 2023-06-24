package com.example.checkpoint3.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.checkpoint3.databinding.FragmentHomeBinding
import java.util.Random

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.button.setOnClickListener {

            viewModel.dogsLiveData.observe(viewLifecycleOwner) { dogs ->
                if (dogs != null) {
                    val randomIndex = Random().nextInt(dogs.size)
                    showBreeds(dogs[randomIndex])
                }
            }
        }
        viewModel.getDogs()
        return root
    }

    private fun showBreeds(breeds: DogsRemote){
        binding.textHome.text = breeds.breed
        binding.image.load(breeds.img)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}