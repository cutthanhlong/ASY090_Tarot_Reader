package com.example.basekotlin

import android.app.Application
import com.example.basekotlin.util.SharedPreUtils


class MyApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        SharedPreUtils.init(this)

    }


}