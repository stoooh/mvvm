package com.example.checkpoint3.ui.home

import retrofit2.http.GET

interface DogAPI {
 @GET("dog_breeds")
 suspend fun getDogs() : List<DogsRemote>
}