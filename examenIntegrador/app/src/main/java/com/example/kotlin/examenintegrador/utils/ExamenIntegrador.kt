package com.example.kotlin.examenintegrador.utils

import android.app.Application
import com.example.kotlin.examenintegrador.data.network.NetworkModuleDI

class ExamenIntegrador : Application() {
    override fun onCreate() {
        super.onCreate()
        NetworkModuleDI.initializeParse(this)
    }
}
