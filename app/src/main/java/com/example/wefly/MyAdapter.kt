//package com.example.wefly
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.google.android.material.imageview.ShapeableImageView
//
//class MyAdapter (private var newList : ArrayList<News>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
//
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
//        return MyViewHolder(itemView)
//    }
//
//    override fun getItemCount(): Int {
//        return newList.size
//    }
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        val curredItem = newList[position]
//        holder.titleImage.setImageResource(curredItem.titleImage)
//        holder.tvHeading.text = curredItem.heading
//    }
//
//    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
//        val titleImage : ImageView = itemView.findViewById(R.id.title_image)
//        val tvHeading : TextView = itemView.findViewById(R.id.tvHeading)
//    }
//
//    fun filterList(filteredList: ArrayList<News>) {
//        newList = filteredList
//        notifyDataSetChanged()
//    }
//
//}











package com.example.wefly

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter (private var newList : ArrayList<News>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return newList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val curredItem = newList[position]
        holder.titleImage.setImageResource(curredItem.titleImage)
        holder.heading.text = curredItem.heading
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val titleImage : ImageView = itemView.findViewById(R.id.title_image)
        val heading : TextView = itemView.findViewById(R.id.tvHeading) //modified
    }

}



