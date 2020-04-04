package com.hsboo.mylolprogammer.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hsboo.mylolprogammer.R
import com.hsboo.presentation.main.MainContract

class MainActivity : AppCompatActivity(), MainContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
