package com.example.kotlinguardian.response
import com.google.gson.annotations.SerializedName

data class Fields (
    @SerializedName("thumbnail")
    var thumbnail: String? = null
)