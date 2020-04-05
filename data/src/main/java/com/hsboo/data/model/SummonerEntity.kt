package com.hsboo.data.model

data class SummonerEntity(
    val accountId: String,
    val profileIconId: Int,
    val revisionDate: Long,
    val name: String,
    val id: String,
    val puuid: String,
    val summonerLevel: Long
)