package com.hsboo.domain.repository

import com.hsboo.data.model.Summoner

interface SummonerRepository {
    fun getSummonerInfoByName(name: String): Summoner
}