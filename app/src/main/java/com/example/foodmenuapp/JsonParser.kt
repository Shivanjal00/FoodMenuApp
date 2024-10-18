package com.example.foodmenuapp

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object JsonParser {
    fun parseMenuData(jsonString: String): MenuData {
        val type = object : TypeToken<MenuData>() {}.type
        return Gson().fromJson(jsonString, type)
    }
}
