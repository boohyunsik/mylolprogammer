package com.hsboo.domain.repository

import com.hsboo.data.model.Summoner
import io.reactivex.Single

interface SummonerRepository {
    fun getSummonerInfoByName(name: String): Single<Summoner>
}