package com.hsboo.domain.interactor

import com.hsboo.domain.executor.PostExecutionThread
import com.hsboo.domain.executor.ThreadExecutor
import io.reactivex.Completable
import io.reactivex.disposables.Disposables
import io.reactivex.schedulers.Schedulers

abstract class CompletableUseCase<T, in Params> protected constructor(
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread) {

    private val subscription = Disposables.empty()

    protected abstract fun buildCompletableUseCase(params: Params): Completable

    fun execute(params: Params): Completable {
        return this.buildCompletableUseCase(params)
            .subscribeOn(Schedulers.from(threadExecutor))
            .observeOn(postExecutionThread.scheduler)
    }

    fun unSubscribe() {
        if (!subscription.isDisposed) {
            subscription.dispose()
        }
    }
}