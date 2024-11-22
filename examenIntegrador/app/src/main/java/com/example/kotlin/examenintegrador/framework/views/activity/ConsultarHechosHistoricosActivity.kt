package com.example.kotlin.examenintegrador.framework.views.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.examenintegrador.R
import androidx.lifecycle.Observer
import com.example.kotlin.examenintegrador.data.network.repository.ConsultarHechosHistoricosRepository
import com.example.kotlin.examenintegrador.databinding.ActivityConsultarHechosHistoricosBinding
import com.example.kotlin.examenintegrador.domain.ConsultarHechosHistoricosRequirement
import com.example.kotlin.examenintegrador.framework.adapter.ConsultarHechosHistoricosAdapter
import com.example.kotlin.examenintegrador.framework.viewmodel.ConsultarHechosHistoricosViewModel

class ConsultarHechosHistoricosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConsultarHechosHistoricosBinding
    private lateinit var viewModel: ConsultarHechosHistoricosViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ConsultarHechosHistoricosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializar el binding
        inicializarBinding()

        filtrarViewModel()

        inicializarRecyclerView()

        // Crear instancia de Requirement y ViewModel manualmente
        val hechosHistoricosRepository = ConsultarHechosHistoricosRepository()
        val hechosHistoricosRequirement = ConsultarHechosHistoricosRequirement(hechosHistoricosRepository)

        viewModel = ConsultarHechosHistoricosViewModel(hechosHistoricosRequirement)


        // Llamar a la función para cargar las pruebas
        viewModel.obtenerHechos()

        observarViewModel()

    }
    private fun inicializarBinding() {
        binding = ActivityConsultarHechosHistoricosBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun inicializarRecyclerView() {
        adapter = ConsultarHechosHistoricosAdapter()
        recyclerView = findViewById(R.id.recycleViewHecho)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter
    }

    private fun observarViewModel() {
        // Observar la lista de pruebas desde el ViewModel
        viewModel.hecho.observe(this, Observer { hechos ->
            adapter.submitList(hechos)
        Log.d("Adapter", "InicializarRecyclerView ${hechos}")
        })
    }

    private fun filtrarViewModel() {
        binding.filtro1.setOnClickListener {
            val categoryFilter = "filtro1"
            Log.d("Filter1", "${categoryFilter}")
            val filter = when (categoryFilter) {
                "filtro1" -> "Roman Republic"
                "filtro2" -> "Egypt"
                "filtro3" -> "Greece"
                else -> "" // Default case (e.g., no matching filter)
            }

            if (filter.isNotEmpty()) {
                viewModel.filtrarHechos(filter)
            } else {
                Log.d("Filter", "No valid filter selected")
            }
        }
        binding.filtro2.setOnClickListener {
            val categoryFilter = "filtro2"
            Log.d("Filter2", "${categoryFilter}")
            val filter = when (categoryFilter) {
                "filtro1" -> "Roman Republic"
                "filtro2" -> "Egypt"
                "filtro3" -> "Greece"
                else -> "" // Default case (e.g., no matching filter)
            }

            if (filter.isNotEmpty()) {
                viewModel.filtrarHechos(filter)
            } else {
                Log.d("Filter", "No valid filter selected")
            }
        }
        binding.filtro3.setOnClickListener {
            val categoryFilter = "filtro3"
            Log.d("Filter3", "${categoryFilter}")
            val filter = when (categoryFilter) {
                "filtro1" -> "Roman Republic"
                "filtro2" -> "Egypt"
                "filtro3" -> "Greece"
                else -> "" // Default case (e.g., no matching filter)
            }

            if (filter.isNotEmpty()) {
                viewModel.filtrarHechos(filter)
            } else {
                Log.d("Filter", "No valid filter selected")
            }
        }


    }
}