package com.hsboo.domain.interactor.summoner

import com.hsboo.data.model.Summoner
import com.hsboo.domain.executor.PostExecutionThread
import com.hsboo.domain.executor.ThreadExecutor
import com.hsboo.domain.interactor.SingleUseCase
import com.hsboo.domain.repository.SummonerRepository
import io.reactivex.Single
import javax.inject.Inject

class GetSummoner @Inject constructor(val summonerRepository: SummonerRepository,
                                      threadExecutor: ThreadExecutor,
                                      postExecutionThread: PostExecutionThread)
    : SingleUseCase<Summoner, String>(threadExecutor, postExecutionThread) {

    public override fun buildUseCaseObservable(params: String?): Single<Summoner> {
        return summonerRepository.getSummonerInfoByName(params!!)
    }

}