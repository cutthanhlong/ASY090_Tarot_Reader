package com.example.basekotlin.ui.main

import com.example.basekotlin.base.BaseActivity
import com.example.basekotlin.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {


    override fun onBackPressed() {
        finishThisActivity()
    }

}
