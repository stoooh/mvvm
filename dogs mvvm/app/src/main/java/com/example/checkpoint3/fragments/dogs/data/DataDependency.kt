package com.example.checkpoint3.fragments.dogs.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataDependency {

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

    private val dogApi = retrofit.create(DogAPI::class.java)

    val dogsRepository = DogRepository(dogApi)
}