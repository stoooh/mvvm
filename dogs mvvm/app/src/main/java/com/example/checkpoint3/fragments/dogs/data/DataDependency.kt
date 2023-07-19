package com.example.checkpoint3.fragments.dogs.data

import android.content.Context
import androidx.room.Room
import com.example.checkpoint3.fragments.dogs.DogsDatabase
import com.example.checkpoint3.fragments.dogs.repository.DogsDao
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataDependency {

    lateinit var dogsRepository: DogRepository

    fun inject(appContext: Context) {
        NetworkManager.start(appContext)
        dogsRepository = DogRepository(
            dogsAPI(),
            database(appContext)
        )
    }

    private fun dogsAPI(): DogAPI {
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

        return retrofit.create(DogAPI::class.java)
    }

    private fun database(appContext: Context): DogsDao {

        val db = Room.databaseBuilder(
            appContext,
            DogsDatabase.AppDatabase::class.java, "dogs_database"
        ).build()
        return db.breedDao()
    }

    // companion object {
    //      val dogsRepository: DogRepository
    // }
}