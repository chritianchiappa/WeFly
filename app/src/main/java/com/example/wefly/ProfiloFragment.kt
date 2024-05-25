package com.example.wefly

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ProfiloFragment : Fragment() {
    // dichiarazione variables per Viaggi attuali

    private lateinit var adapterAttuali : AdapterViaggiAttuali // dichiarazione dell'adapter
    private lateinit var recyclerViewAttuali : RecyclerView // dichiarazione della recyclerView
    private lateinit var viaggiAttualiArrayList : ArrayList<DataViaggiAttuali> // ArrayList di objects

    lateinit var imageIdAttuali : Array<Int>
    lateinit var titoloViaggioAttuali : Array<String>
    lateinit var viaggiAttuali : Array<String>


    // dichiarazione variables per Viaggi passati

    private lateinit var adapterPassati : AdapterViaggiPassati // dichiarazione dell'adapter
    private lateinit var recyclerViewPassati : RecyclerView // dichiarazione della recyclerView
    private lateinit var viaggiPassatiArrayList : ArrayList<DataViaggiPassati> // ArrayList di objects

    lateinit var imageIdPassati : Array<Int>
    lateinit var titoloViaggioPassati : Array<String>
    lateinit var dataPassati : Array<String>
    lateinit var viaggiPassati : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profilo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitializeAttuali()
        dataInitializePassati()
        val layoutManagerAttuali = LinearLayoutManager(context)
        recyclerViewAttuali = view.findViewById(R.id.recyclerViewViaggiAttuali)
        recyclerViewAttuali.layoutManager = layoutManagerAttuali
        recyclerViewAttuali.setHasFixedSize(true)
        adapterAttuali = AdapterViaggiAttuali(viaggiAttualiArrayList)
        recyclerViewAttuali.adapter = adapterAttuali


        val layoutManagerPassati = LinearLayoutManager(context)
        recyclerViewPassati = view.findViewById(R.id.recyclerViewViaggiPassati)
        recyclerViewPassati.layoutManager = layoutManagerPassati
        recyclerViewPassati.setHasFixedSize(true)
        adapterPassati = AdapterViaggiPassati(viaggiPassatiArrayList)
        recyclerViewPassati.adapter = adapterPassati
    }

    private fun dataInitializeAttuali(){

        viaggiAttualiArrayList = arrayListOf<DataViaggiAttuali>()

        imageIdAttuali = arrayOf(
            R.drawable.background_travel,
            R.drawable.background_travel,
            R.drawable.background_travel
        )

        titoloViaggioAttuali = arrayOf (
            "Londra",
            "Londra",
            "Londra"
        )

        viaggiAttuali = arrayOf(
            "Viaggio 1",
            "Viaggio 2",
            "Viaggio 3"
        )

        for (i in imageIdAttuali.indices){

            val viaggiAttuali = DataViaggiAttuali(imageIdAttuali[i], titoloViaggioAttuali[i])
            viaggiAttualiArrayList.add(viaggiAttuali)
        }

    }

    private fun dataInitializePassati(){

        viaggiPassatiArrayList = arrayListOf<DataViaggiPassati>()

        imageIdPassati = arrayOf(
            R.drawable.background_travel,
            R.drawable.background_travel,
            R.drawable.background_travel,
            R.drawable.background_travel
        )

        titoloViaggioPassati = arrayOf (
            "Londra",
            "Londra",
            "Londra",
            "Londra"
        )

        dataPassati = arrayOf(
            "10/10/2020",
            "10/10/2020",
            "10/10/2020",
            "10/10/2020"
        )

        viaggiPassati = arrayOf(
            "Viaggio 1",
            "Viaggio 2",
            "Viaggio 3",
            "Viaggio 4"
        )

        for (i in imageIdPassati.indices){

            val viaggiPassati = DataViaggiPassati(imageIdPassati[i], titoloViaggioPassati[i], dataPassati[i])
            viaggiPassatiArrayList.add(viaggiPassati)
        }

    }

}