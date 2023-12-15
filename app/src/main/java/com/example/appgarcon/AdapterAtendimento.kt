package com.example.appgarcon

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterAtendimento(

    private val Atendimentos : List<String>

) : RecyclerView.Adapter<AdapterAtendimento.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.itens_atendimento_adapter,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = Atendimentos.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val atendimento = Atendimentos[position]

        holder.txtAtendimento.text = atendimento
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val txtAtendimento : TextView = itemView.findViewById(R.id.txtAtendimento)
    }
}



