package com.example.basekotlin.ui.setting

import android.view.View
import com.example.basekotlin.R
import com.example.basekotlin.base.BaseActivity
import com.example.basekotlin.base.tap
import com.example.basekotlin.databinding.ActivitySettingsBinding
import com.example.basekotlin.ui.about.AboutActivity
import com.example.basekotlin.ui.language.LanguageActivity
import com.example.basekotlin.util.SettingManager
import com.example.basekotlin.util.SharedPreUtils
import com.example.basekotlin.util.SystemUtil

class SettingActivity : BaseActivity<ActivitySettingsBinding>(ActivitySettingsBinding::inflate) {


    override fun getData() {
        when (SystemUtil.getPreLanguage(this)) {
            "en" -> binding.tvLang.text = resources.getString(R.string.english)
            "pt" -> binding.tvLang.text = resources.getString(R.string.portuguese)
            "es" -> binding.tvLang.text = resources.getString(R.string.spanish)
            "de" -> binding.tvLang.text = resources.getString(R.string.german)
            "fr" -> binding.tvLang.text = resources.getString(R.string.french)
            "zh" -> binding.tvLang.text = resources.getString(R.string.china)
            "hi" -> binding.tvLang.text = resources.getString(R.string.hindi)
            "in" -> binding.tvLang.text = resources.getString(R.string.indonesia)
        }

        if (SharedPreUtils.getInstance().isRated(this)) {
            binding.btnRateUs.visibility = View.GONE
        }
    }

    override fun initView() {
        binding.viewTop.tvToolBar.text = getString(R.string.settings)
        binding.viewTop.tvToolBar.isAllCaps = true
        binding.viewTop.ivLeft.visibility = View.GONE
        binding.viewTop.ivRight.visibility = View.GONE

    }

    override fun bindView() {

        binding.btnLanguage.tap { startNextActivity(LanguageActivity::class.java, null) }

        binding.btnShare.tap { SettingManager.onShare(this) }

        binding.btnRateUs.tap { SettingManager.onRateUs(this, binding.btnRateUs) }

        binding.btnFeedback.tap { SettingManager.onFeedback(this) }

        binding.btnAbout.tap { startNextActivity(AboutActivity::class.java, null) }
    }


}