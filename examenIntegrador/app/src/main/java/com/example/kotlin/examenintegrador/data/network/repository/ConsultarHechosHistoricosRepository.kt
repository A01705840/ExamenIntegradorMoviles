package com.example.kotlin.examenintegrador.data.network.repository

import android.util.Log
import com.example.kotlin.examenintegrador.data.network.model.HechosModel
import com.parse.ParseCloud
import com.parse.ParseException
import com.parse.ParseObject

class ConsultarHechosHistoricosRepository {
    fun consultarHistoricalData(): List<HechosModel> {
        val params = HashMap<String, Any>() // Empty parameters for the cloud function

        return try {
            val result = ParseCloud.callFunction<Map<String, Any>>(
                "hello",
                params
            )
            Log.d("RepoResult", "${result}")

            val dataList = (result["data"] as? List<ParseObject>)?.map {
                dataMap ->
                Log.d("Repodata", "1 ${dataMap}")
                Log.d("Repo", "2 ${dataMap["date"]}")
                    Log.d("Repo", "3 ${dataMap["description"]}")
                Log.d("Repo", "4 ${dataMap["objectId"]}")
                HechosModel(
                    date = dataMap["date"] as? String ?: "Fecha no disponible",
                    description = dataMap["description"] as? String ?: "Descripcion no disponible",
                    objectId = dataMap["objectId"] as? String ?: "Data no disponible",
                    category2 = dataMap["category2"] as? String ?: "Nacion no disponible"
                )
            } ?: emptyList()
            Log.d("Repo", "$dataList")
            dataList
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("Repo", "${e.message}")
            emptyList()
        }


    }

}