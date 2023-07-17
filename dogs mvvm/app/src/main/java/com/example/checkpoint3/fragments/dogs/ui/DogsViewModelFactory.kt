package com.example.checkpoint3.fragments.dogs.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.checkpoint3.fragments.dogs.DogsDatabase
import com.example.checkpoint3.fragments.dogs.DomainDependency

class DogsViewModelFactory: ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val getDogsUseCase = DomainDependency.getDogsUseCase
        return DogsViewModel(getDogsUseCase) as T
    }
}