package com.hsboo.presentation.record

import com.hsboo.presentation.BasePresenter

interface RecordContract {

    interface View {

    }

    interface Presenter: BasePresenter {
        fun getRecordBySummonerName(name: String)
    }
}