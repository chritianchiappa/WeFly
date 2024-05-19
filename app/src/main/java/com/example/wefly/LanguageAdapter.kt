package com.example.wefly

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView

class LanguageAdapter(val data: List<LanguageData>) : RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder>(){

    inner class LanguageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val logo : ImageView = itemView.findViewById(R.id.logoIv)
        val titleTv : TextView = itemView.findViewById(R.id.titleTv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}