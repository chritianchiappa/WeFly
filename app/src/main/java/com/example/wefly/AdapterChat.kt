package com.example.wefly

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterChat (private val newList : ArrayList<DataChat>) : RecyclerView.Adapter<AdapterChat.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_chat,
            parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = newList[position]
        holder.immagineProfilo.setImageResource(currentItem.immagineProfilo)
        holder.nome.text = currentItem.nome
        holder.cognome.text = currentItem.cognome
    }

    override fun getItemCount(): Int {
        return newList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val immagineProfilo : ImageView = itemView.findViewById(R.id.foto_profilo)
        val nome : TextView = itemView.findViewById(R.id.nome)
        val cognome : TextView = itemView.findViewById(R.id.cognome)

    }

}