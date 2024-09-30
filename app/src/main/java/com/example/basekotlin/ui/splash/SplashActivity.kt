package com.example.basekotlin.ui.splash

import android.os.Handler
import com.example.basekotlin.base.BaseActivity
import com.example.basekotlin.databinding.ActivitySplashBinding
import com.example.basekotlin.ui.language.LanguageStartActivity
import com.example.basekotlin.ui.main.MainActivity
import com.example.basekotlin.util.SharedPreUtils
import kotlinx.coroutines.MainScope

class SplashActivity : BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate) {

    override fun initView() {
        SharedPreUtils.getInstance().setCountOpenApp(this)

        Handler(mainLooper).postDelayed({
            startNextActivity()
        }, 1500)
    }

    private fun startNextActivity() {
        startNextActivity(MainActivity::class.java, null)
        finishAffinity()
    }

    override fun onBackPressed() {}
}