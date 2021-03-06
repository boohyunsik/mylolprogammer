package com.hsboo.data

import com.hsboo.data.model.SummonerEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface RiotService {
    fun getRecordBySummonerId(name: String)

    @GET("/lol/summoner/v4/summoners/by-account/{encryptedAccountId}")
    fun getSummonerIdByEncryptedId(@Path("encryptedAccountId}") encryptedId: String): Single<SummonerEntity>

    @GET("/lol/summoner/v4/summoners/by-name/{summonerName}")
    fun getSummonerByName(@Path("summonerName") name: String): Single<SummonerEntity>
}