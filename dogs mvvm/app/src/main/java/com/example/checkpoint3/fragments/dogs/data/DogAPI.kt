package com.example.checkpoint3.fragments.dogs.data

import retrofit2.http.GET

interface DogAPI {
 @GET("dog_breeds")
 suspend fun getDogs() : List<DogsRemote>
}