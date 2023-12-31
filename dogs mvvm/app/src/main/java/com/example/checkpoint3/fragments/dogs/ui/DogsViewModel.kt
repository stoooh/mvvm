package com.example.checkpoint3.fragments.dogs.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.checkpoint3.fragments.dogs.data.DogsRemote
import com.example.checkpoint3.fragments.dogs.domain.Dogs
import com.example.checkpoint3.fragments.dogs.domain.DogsUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import java.util.Random

class DogsViewModel(private val getDogsUseCase: DogsUseCase) : ViewModel() {

    val dogsLiveData = MutableSharedFlow<Dogs>()
    //val dogsLiveData : MutableLiveData<Dogs> = _dogsLiveData

    fun getDogs(){
        viewModelScope.launch {
            val breeds = getDogsUseCase.invoke()
            val randomDog = getRandomDog(breeds)
            dogsLiveData.emit(randomDog)
        }
    }

    private fun getRandomDog(dogs: List<Dogs>): Dogs {
            val randomIndex = Random().nextInt(dogs.size)
        return dogs[randomIndex]
    }

}