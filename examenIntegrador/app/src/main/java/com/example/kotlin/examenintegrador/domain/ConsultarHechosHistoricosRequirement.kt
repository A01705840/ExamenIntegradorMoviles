package com.example.kotlin.examenintegrador.domain

import com.example.kotlin.examenintegrador.data.network.model.HechosModel
import com.example.kotlin.examenintegrador.data.network.repository.ConsultarHechosHistoricosRepository

class ConsultarHechosHistoricosRequirement (private val repository: ConsultarHechosHistoricosRepository) {
    fun consultarHechosHistoricos() : List<HechosModel> {
        return repository.consultarHistoricalData()
    }
}