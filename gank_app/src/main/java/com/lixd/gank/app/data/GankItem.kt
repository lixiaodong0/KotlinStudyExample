package com.lixd.gank.app.data

import com.google.gson.annotations.SerializedName

data class GankItem(@SerializedName("_id") val id: String,
                    val createdAt: String,
                    val desc: String,
                    val publishedAt: String,
                    val source: String,
                    val type: String,
                    val url: String,
                    val images:List<String>,
                    val used: Boolean,
                    val who: String) {
}