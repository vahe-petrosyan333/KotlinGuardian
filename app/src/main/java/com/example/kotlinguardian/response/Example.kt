package com.example.kotlinguardian.response

import com.google.gson.annotations.SerializedName

data class Example (
    @SerializedName("response")
    var response: Response? = null
)
