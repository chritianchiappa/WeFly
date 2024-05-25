package com.example.wefly

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ChatFragment : Fragment() {

    // dichiarazione variables

    private lateinit var adapter : AdapterChat // dichiarazione dell'adapter
    private lateinit var recyclerView : RecyclerView // dichiarazione della recyclerView
    private lateinit var chatArrayList : ArrayList<DataChat> // ArrayList di objects

    lateinit var imageId : Array<Int>
    lateinit var nome : Array<String>
    lateinit var cognome : Array<String>
    lateinit var chat : Array<String>

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
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerViewChat)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = AdapterChat(chatArrayList)
        recyclerView.adapter = adapter
    }

    private fun dataInitialize(){

        chatArrayList = arrayListOf<DataChat>()

        imageId = arrayOf(
            R.drawable.profile_icon
        )

        nome = arrayOf (
            "Michele"
        )

        cognome = arrayOf(
            "Carloni"
        )

        chat = arrayOf(
            "Viaggio 1"
        )

        for (i in imageId.indices){

            val chat = DataChat(imageId[i], nome[i], cognome[i])
            chatArrayList.add(chat)
        }

    }

}