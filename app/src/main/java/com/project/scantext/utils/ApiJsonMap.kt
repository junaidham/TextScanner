package com.project.scantext.utils

import com.google.gson.JsonObject
import org.json.JSONException

object ApiJsonMap {

    @JvmStatic
    fun calDecodeBcode(msg: String): JsonObject {
        val jsonObject1 = JsonObject()
        try {
            jsonObject1.addProperty(VariablesConstant.MESSAGE1,msg)
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return jsonObject1
    }


}