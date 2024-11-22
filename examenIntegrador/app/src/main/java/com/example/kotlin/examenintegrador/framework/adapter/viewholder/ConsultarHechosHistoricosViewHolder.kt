package com.example.kotlin.examenintegrador.framework.adapter.viewholder

import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.examenintegrador.R
import com.example.kotlin.examenintegrador.data.network.model.HechosModel

class ConsultarHechosHistoricosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val descripcion : TextView = itemView.findViewById(R.id.descripcion)
    private val date : TextView = itemView.findViewById(R.id.date)

    fun bind(hechosModel: HechosModel){
         descripcion.text = hechosModel.description
         date.text = hechosModel.date
    }
}