package com.hsboo.data

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RiotServiceTest {

    lateinit var riotService: RiotServiceImpl

    @Before fun setup() {
        riotService = RiotServiceImpl()
    }

    @Test fun test_getSummonerByName_withMyAccount() {
        riotService.getSummonerByName("하위빅스비")
            .subscribe {
                it -> println(it)
            }
    }

    @Test fun test_getSummonerByName_caseOfError() {
        riotService.getSummonerByName(" ")
            .subscribe()
    }
}