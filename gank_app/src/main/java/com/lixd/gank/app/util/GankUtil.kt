package com.lixd.gank.app.util

import android.text.TextUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lixd.gank.app.data.GankItem
import org.json.JSONObject

object GankUtil {
    fun parseTodayData(gankJson: String): LinkedHashMap<String, List<GankItem>?> {
        val map = LinkedHashMap<String, List<GankItem>?>()
        if (!TextUtils.isEmpty(gankJson)) {
            try {
                val gankJsonObject = JSONObject(gankJson)
                val resultObject = gankJsonObject.optJSONObject("results")
                if (resultObject != null) {
                    val gson = Gson()
                    for (item in resultObject.keys()) {
                        val gankItemJson = resultObject.optJSONArray(item)?.toString()
                        val key = item
                        val valus: List<GankItem>? = gson.fromJson(gankItemJson, object : TypeToken<List<GankItem>?>() {}.type)
                        map.put(key, valus)
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return map
    }
}