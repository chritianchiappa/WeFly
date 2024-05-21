package com.example.wefly

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale


class ViaggiFragment : Fragment() {
    private lateinit var adapter : MyAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var newsArrayList : ArrayList<News>

    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>
    lateinit var news : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initial setup that doesn't require view references can go here
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_viaggi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
    }

    private fun dataInitialize() {
        newsArrayList = arrayListOf<News>()

        imageId = arrayOf(
            R.drawable.logo_png,
            R.drawable.google_icon,
            R.drawable.facebook_icon
        )

        heading = arrayOf(
            getString(R.string.prova1),
            getString(R.string.prova2),
            getString(R.string.prova3)
        )

        news = arrayOf(
            getString(R.string.prova1),
            getString(R.string.prova2),
            getString(R.string.prova3)
        )

        for (i in imageId.indices) {
            val news = News(imageId[i], heading[i])
            newsArrayList.add(news)
        }

    }
}