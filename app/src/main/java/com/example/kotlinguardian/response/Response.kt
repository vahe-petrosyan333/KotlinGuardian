package com.example.kotlinguardian.response
import com.google.gson.annotations.SerializedName

data class Response (
    @SerializedName("status")
    var status: String? = null,

    @SerializedName("userTier")
    var userTier: String? = null,

    @SerializedName("total")
    var total:Int = 0,

    @SerializedName("startIndex")
    var startIndex:Int = 0,

    @SerializedName("pageSize")
    var pageSize:Int = 0,

    @SerializedName("currentPage")
    var currentPage:Int = 0,

    @SerializedName("pages")
    var pages:Int = 0,

    @SerializedName("orderBy")
    var orderBy: String? = null,

    @SerializedName("results")
    var results: List<Result>? = null
)