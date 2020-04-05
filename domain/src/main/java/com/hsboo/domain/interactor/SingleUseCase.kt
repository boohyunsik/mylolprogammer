package com.hsboo.domain.interactor

import com.hsboo.domain.executor.PostExecutionThread
import com.hsboo.domain.executor.ThreadExecutor
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

abstract class SingleUseCase<T, in Params> (
    private val threadExecutor: ThreadExecutor,
    private val postThreadExecutor: PostExecutionThread) {

    private var disposables = CompositeDisposable()

    protected abstract fun buildUseCaseObservable(params: Params? = null): Single<T>

    open fun execute(singleObserver: DisposableSingleObserver<T>, params: Params? = null) {
        val single = this.buildUseCaseObservable(params)
            .subscribeOn(Schedulers.from(threadExecutor))
            .observeOn(postThreadExecutor.scheduler) as Single<T>
        addDisposable(single.subscribeWith(singleObserver))
    }

    fun dispose() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }

    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }
}