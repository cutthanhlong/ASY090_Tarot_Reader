package com.example.basekotlin.ui.intro

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.basekotlin.base.BaseAdapter
import com.example.basekotlin.databinding.ItemIntroBinding
import com.example.basekotlin.data.model.IntroModel

class IntroAdapter : BaseAdapter<IntroModel, ItemIntroBinding>() {

    override fun setBinding(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int,
    ): ItemIntroBinding {
        return ItemIntroBinding.inflate(inflater, parent, false)
    }

    override fun addListData(newList: MutableList<IntroModel>) {
        listData.clear()
        listData.addAll(newList)
        notifyDataSetChanged()
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun setData(binding: ItemIntroBinding, item: IntroModel, layoutPosition: Int) {
        binding.tvTitle.text = context!!.getString(item.title)
        binding.tvContent.text = context!!.getString(item.content)
//        context?.let { Glide.with(it).load(it.getDrawable(item.image)).into(binding.ivIntro) }
    }

    override fun getItemCount(): Int = listData.size

}