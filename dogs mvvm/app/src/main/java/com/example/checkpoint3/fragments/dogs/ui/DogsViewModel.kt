package com.example.checkpoint3.fragments.dogs.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.checkpoint3.fragments.dogs.data.DogsRemote
import com.example.checkpoint3.fragments.dogs.domain.DogsDomainData
import com.example.checkpoint3.fragments.dogs.domain.DogsUseCase
import kotlinx.coroutines.launch
import java.util.Random

class DogsViewModel(private val getDogsUseCase: DogsUseCase) : ViewModel() {

    private val _dogsLiveData = MutableLiveData<DogsRemote?>()
    val dogsLiveData : LiveData<DogsRemote?> = _dogsLiveData

    fun getDogs(){
        viewModelScope.launch {
            val breeds = getDogsUseCase
            val randomDog = getRandomDog(breeds)
            _dogsLiveData.postValue(randomDog)
        }
    }

    fun getRandomDog(dogs: List<DogsRemote>): DogsRemote? {
            val randomIndex = Random().nextInt(dogs.size)
        return dogs[randomIndex]
    }

}