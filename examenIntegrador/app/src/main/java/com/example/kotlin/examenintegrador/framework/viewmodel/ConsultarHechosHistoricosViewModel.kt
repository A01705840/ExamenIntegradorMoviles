package com.example.kotlin.examenintegrador.framework.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.examenintegrador.data.network.model.HechosModel
import com.example.kotlin.examenintegrador.domain.ConsultarHechosHistoricosRequirement
import kotlinx.coroutines.launch
import android.util.Log


class ConsultarHechosHistoricosViewModel (private val Requirement: ConsultarHechosHistoricosRequirement) : ViewModel (){
    private val _hechos = MutableLiveData<List<HechosModel>>()
    val hecho: LiveData<List<HechosModel>> get() = _hechos

    fun obtenerHechos() {
        viewModelScope.launch {
            val listaHechosModel = Requirement.consultarHechosHistoricos()
            Log.d("VM", "hi ${listaHechosModel}")
            _hechos.postValue(listaHechosModel)
        }
    }

    fun filtrarHechos(categoryFilter: String) {
        viewModelScope.launch {
            val listaHechosModel = Requirement.consultarHechosHistoricos()
            val filteredList = listaHechosModel.filter { hecho ->
                hecho.category2 == categoryFilter
            }

            Log.d("VM", "Filtered list: $filteredList")

            _hechos.postValue(filteredList)
        }
    }
}