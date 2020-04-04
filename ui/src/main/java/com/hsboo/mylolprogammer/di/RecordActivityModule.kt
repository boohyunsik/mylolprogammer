package com.hsboo.mylolprogammer.di

import com.hsboo.mylolprogammer.record.RecordActivity
import com.hsboo.presentation.record.RecordContract
import com.hsboo.presentation.record.RecordPresenter
import dagger.Module
import dagger.Provides

@Module
class RecordActivityModule {
    @PerActivity
    @Provides
    internal fun provideRecordView(recordActivity: RecordActivity): RecordContract.View = recordActivity

    @PerActivity
    @Provides
    internal fun provideRecordPresenter(recordActivity: RecordActivity): RecordContract.Presenter = RecordPresenter(recordActivity)
}