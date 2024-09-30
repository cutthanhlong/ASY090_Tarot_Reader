package com.example.basekotlin.ui.language

import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.basekotlin.R
import com.example.basekotlin.base.BaseActivity
import com.example.basekotlin.base.tap
import com.example.basekotlin.databinding.ActivityLanguageStartBinding
import com.example.basekotlin.data.model.LanguageModel
import com.example.basekotlin.ui.intro.IntroActivity
import com.example.basekotlin.ui.language.adapter.LanguageAdapter
import com.example.basekotlin.util.SystemUtil
import java.util.Locale

class LanguageStartActivity :
    BaseActivity<ActivityLanguageStartBinding>(ActivityLanguageStartBinding::inflate) {

    private var listLanguage: MutableList<LanguageModel> = mutableListOf()
    private var codeLang: String? = null
    private var toast: Toast? = null

    override fun initView() {
        initData()
        codeLang = Locale.getDefault().language
        binding.viewTop.tvToolBar.text = getString(R.string.language)
        binding.viewTop.tvToolBar.setTextColor(ContextCompat.getColor(this, R.color.black))
        binding.viewTop.tvToolBar.gravity = Gravity.START
        binding.viewTop.ivRight.visibility = View.VISIBLE

        val languageAdapter = LanguageAdapter(onClick = { codeLang = it })
        listLanguage.let { languageAdapter.addListData(it) }
        binding.rcvLangStart.adapter = languageAdapter
    }

    override fun bindView() {

        binding.viewTop.ivRight.tap {
            SystemUtil.saveLocale(this, codeLang)

            var count = 0
            for (i in 0 until listLanguage.size) {
                if (listLanguage[i].active) {
                    count++
                    break
                }
            }
            if (count > 0) {
                SystemUtil.saveLocale(this, codeLang)
                startNextActivity()
            } else {
                if (toast != null) toast!!.cancel()
                toast = Toast.makeText(
                    this, getString(R.string.please_choose_a_language), Toast.LENGTH_SHORT
                )
                toast!!.show()
            }
        }
    }

    private fun startNextActivity() {
        startNextActivity(IntroActivity::class.java, null)
        finish()
    }

    private fun initData() {
        listLanguage = ArrayList()
        val lang = Locale.getDefault().language
        listLanguage.add(LanguageModel("English", "en", false))
        listLanguage.add(LanguageModel("China", "zh", false))
        listLanguage.add(LanguageModel("French", "fr", false))
        listLanguage.add(LanguageModel("German", "de", false))
        listLanguage.add(LanguageModel("Hindi", "hi", false))
        listLanguage.add(LanguageModel("Indonesia", "in", false))
        listLanguage.add(LanguageModel("Portuguese", "pt", false))
        listLanguage.add(LanguageModel("Spanish", "es", false))

        for (i in listLanguage.indices) {
            if (listLanguage[i].code == lang) {
                listLanguage.add(0, listLanguage[i])
                listLanguage.removeAt(i + 1)
            }
        }
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}
