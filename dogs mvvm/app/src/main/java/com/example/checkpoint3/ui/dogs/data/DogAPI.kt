package com.example.checkpoint3.ui.dogs.data

import retrofit2.http.GET

interface DogAPI {
 @GET("dog_breeds")
 suspend fun getDogs() : List<DogsRemote>
}