package com.example.basekotlin.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LanguageModel(
    var name: String, var code: String, var active: Boolean,
) : Parcelable

@Parcelize
data class IntroModel(
    var title: Int = -1, var content: Int = -1, var image: Int = 0,
) : Parcelable