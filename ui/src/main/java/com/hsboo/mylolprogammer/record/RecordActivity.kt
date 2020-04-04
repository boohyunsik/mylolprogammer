package com.hsboo.mylolprogammer.record

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hsboo.mylolprogammer.R
import com.hsboo.presentation.record.RecordContract

class RecordActivity : AppCompatActivity(), RecordContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record)

    }
}
