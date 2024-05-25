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

    // dichiarazione variables

    private lateinit var adapter : AdapterElencoViaggi // dichiarazione dell'adapter
    private lateinit var recyclerView : RecyclerView // dichiarazione della recyclerView
    private lateinit var viaggiArrayList : ArrayList<DataElencoViaggi> // ArrayList di objects

    lateinit var imageId : Array<Int>
    lateinit var titoloViaggio : Array<String>
    lateinit var data : Array<String>
    lateinit var partecipanti : Array<String>
    lateinit var viaggi : Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_viaggi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = AdapterElencoViaggi(viaggiArrayList)
        recyclerView.adapter = adapter
    }

    private fun dataInitialize(){

        viaggiArrayList = arrayListOf<DataElencoViaggi>()

        imageId = arrayOf(
            R.drawable.background_travel,
            R.drawable.background_travel,
            R.drawable.background_travel,
            R.drawable.background_travel
        )

        titoloViaggio = arrayOf (
            "Londra",
            "Londra",
            "Londra",
            "Londra",
            "Londra",
            "Londra",
            "Londra"
        )

        data = arrayOf(
            "20/03/2022",
            "20/03/2022",
            "20/03/2022",
            "20/03/2022",
            "20/03/2022",
            "20/03/2022",
            "20/03/2022"
        )

        partecipanti = arrayOf (
            "4/6",
            "4/6",
            "4/6",
            "4/6",
            "4/6",
            "4/6",
            "4/6"
        )

        viaggi = arrayOf(
            "Viaggio 1",
            "Viaggio 2",
            "Viaggio 3",
            "Viaggio 4",
            "Viaggio 5",
            "Viaggio 6",
            "Viaggio 7"
        )

        for (i in imageId.indices){

            val viaggi = DataElencoViaggi(imageId[i], titoloViaggio[i], data[i], partecipanti[i])
            viaggiArrayList.add(viaggi)
        }

    }


}