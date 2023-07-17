package com.example.checkpoint3.fragments.dashboard

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.checkpoint3.databinding.FragmentDashboardBinding

class SharedPreferences : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private lateinit var editText: EditText
    private lateinit var sharedPreferences: SharedPreferences
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        ViewModelProvider(this)[SharedPreferencesViewModel::class.java]

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)

        editText = binding.textDashboard
        sharedPreferences = requireActivity().getSharedPreferences("edittext", Context.MODE_PRIVATE)

        val savedText = sharedPreferences.getString("text", null)
        editText.setText(savedText)
        return binding.root
    }

    override fun onPause() {
        super.onPause()
        val editor = sharedPreferences.edit()
        editor.putString("text", editText.text.toString())
        editor.apply()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}