package com.example.wefly

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterElencoViaggi (private val newList : ArrayList<DataElencoViaggi>) : RecyclerView.Adapter<AdapterElencoViaggi.MyViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,
            parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = newList[position]
        holder.titoloImmagine.setImageResource(currentItem.titoloImmagine)
        holder.titoloViaggio.text = currentItem.titoloViaggio
        holder.data.text = currentItem.data
        holder.partecipanti.text = currentItem.partecipanti
    }

    override fun getItemCount(): Int {
        return newList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titoloImmagine : ImageView = itemView.findViewById(R.id.title_image)
        val titoloViaggio : TextView = itemView.findViewById(R.id.titolo_viaggio)
        val data : TextView = itemView.findViewById(R.id.data)
        val partecipanti : TextView = itemView.findViewById(R.id.partecipanti)

    }

}