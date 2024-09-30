package com.example.basekotlin.ui.permission

import com.example.basekotlin.base.BaseActivity
import com.example.basekotlin.base.tap
import com.example.basekotlin.databinding.ActivityPermissionBinding
import com.example.basekotlin.ui.main.MainActivity

class PermissionActivity :
    BaseActivity<ActivityPermissionBinding>(ActivityPermissionBinding::inflate) {

    override fun initView() {}

    override fun bindView() {
        binding.tvContinue.tap {
            startNextActivity()
        }
    }

    private fun startNextActivity() {
        startNextActivity(MainActivity::class.java, null)
        finishAffinity()
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}