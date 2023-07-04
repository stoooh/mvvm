package com.example.checkpoint3.fragments.dogs.data

import okhttp3.Interceptor
import okhttp3.Response


const val AUTHORIZATION_HEADER = "X-RapidAPI-Key"
const val KEY_AUTHORIZATION = "4aede6dd3dmsh8c92576de54e9c2p13ea05jsn5c558af1b1ff"

class AuthorizationInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newRequest = request.newBuilder()
            .addHeader(AUTHORIZATION_HEADER, KEY_AUTHORIZATION)
            .build()

        return chain.proceed(newRequest)
    }
}