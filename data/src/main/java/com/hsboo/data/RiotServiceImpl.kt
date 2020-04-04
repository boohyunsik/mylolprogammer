package com.hsboo.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RiotServiceImpl {

        val httpClient = OkHttpClient.Builder()
                .addInterceptor {
                        val request = it.request().newBuilder()
                                .header("X-Riot-Token", "RGAPI-e294feb8-4aa9-47c6-8f8a-5b116cbe8f8f")
                                .method(it.request().method(), it.request().body())
                                .build()
                        it.proceed(request)
                }.build()

        fun getSummonerByEncryptedId(encryptedId: String) = Retrofit.Builder()
                .baseUrl("https://kr.api.riotgames.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build()
                .create(RiotService::class.java)
                .getSummonerIdByEncryptedId(encryptedId)

        fun getSummonerByName(name: String) = Retrofit.Builder()
                .baseUrl("https://kr.api.riotgames.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build()
                .create(RiotService::class.java)
                .getSummonerByName(name)
}