package com.lixd.kotlin.gankio.example.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lixd.kotlin.gankio.example.data.ProjectBean
import org.json.JSONObject

object GankUtil {

    fun formatGankData(jsonResponse: String): List<ProjectBean> {
        val gson = Gson()
        var projectBeans: ArrayList<ProjectBean> = arrayListOf()
        val gankDataJsonObject = JSONObject(jsonResponse)
        if (gankDataJsonObject.has("error") && !gankDataJsonObject.getBoolean("error")) {
            val categoryJsonArray = gankDataJsonObject.getJSONArray("category")
            val resultsJsonObject = gankDataJsonObject.getJSONObject("results")
            if ((categoryJsonArray != null && categoryJsonArray.length() > 0) && resultsJsonObject != null) {
                for (i in 0 until categoryJsonArray.length()) {
                    val key = categoryJsonArray.getString(i)
                    if (resultsJsonObject.has(key)) {
                        val proejctJsonString = resultsJsonObject.getJSONArray(key).toString()
                        val projects: List<ProjectBean> = gson.fromJson(proejctJsonString, object : TypeToken<List<ProjectBean>>() {
                        }.type)
                        if (projects != null && projects.size > 0) {
                            projectBeans.addAll(projects)
                        }
                    }
                }
            }
        }
        return projectBeans
    }

}