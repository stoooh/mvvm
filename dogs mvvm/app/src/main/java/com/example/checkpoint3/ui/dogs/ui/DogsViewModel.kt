package com.example.checkpoint3.ui.dogs.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.checkpoint3.ui.dogs.data.AuthorizationInterceptor
import com.example.checkpoint3.ui.dogs.data.DogAPI
import com.example.checkpoint3.ui.dogs.data.DogsRemote
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Random

class DogsViewModel : ViewModel() {

    private val dogApi : DogAPI

    private val _dogsLiveData = MutableLiveData<DogsRemote?>()
    val dogsLiveData : LiveData<DogsRemote?> = _dogsLiveData

    init {

        val authorization = AuthorizationInterceptor()

        val logging = HttpLoggingInterceptor()

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor(authorization)
            .build()


        val retrofit = Retrofit.Builder()
            .baseUrl("https://dog-breeds2.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        dogApi = retrofit.create(DogAPI::class.java)
    }

    fun getDogs(){
        viewModelScope.launch {
            val breeds = dogApi.getDogs()
            val randomDog = getRandomDog(breeds)
            _dogsLiveData.postValue(randomDog)
        }
    }

    fun getRandomDog(dogs: List<DogsRemote>): DogsRemote? {

            val randomIndex = Random().nextInt(dogs.size)
        return dogs[randomIndex]
    }

}