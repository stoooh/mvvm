package com.example.checkpoint3.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeViewModel : ViewModel() {

    private val dogApi : DogAPI

    private val _dogsLiveData = MutableLiveData<List<DogsRemote>>()
    val dogsLiveData : LiveData<List<DogsRemote>> = _dogsLiveData

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
            _dogsLiveData.postValue(breeds)
        }
    }
}