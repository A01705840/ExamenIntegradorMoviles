package com.example.kotlin.examenintegrador.framework.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.kotlin.examenintegrador.R
import com.example.kotlin.examenintegrador.data.network.model.HechosModel
import com.example.kotlin.examenintegrador.framework.adapter.viewholder.ConsultarHechosHistoricosViewHolder


class ConsultarHechosHistoricosAdapter : ListAdapter<HechosModel, ConsultarHechosHistoricosViewHolder>(HechoDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConsultarHechosHistoricosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hecho,parent,false)
        return ConsultarHechosHistoricosViewHolder(view)
    }

    override fun onBindViewHolder(holder: ConsultarHechosHistoricosViewHolder, position: Int) {
        val hechosModel = getItem(position)?: return
        holder.bind(hechosModel)
    }

    class HechoDiffCallback : DiffUtil.ItemCallback<HechosModel>() {
        override fun areItemsTheSame(oldItem: HechosModel, newItem: HechosModel): Boolean {
            return oldItem.objectId == newItem.objectId
        }

        override fun areContentsTheSame(oldItem: HechosModel, newItem: HechosModel): Boolean {
            return oldItem == newItem
        }
    }
}