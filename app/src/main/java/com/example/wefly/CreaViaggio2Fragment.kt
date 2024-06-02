package com.example.wefly

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import com.google.android.material.checkbox.MaterialCheckBox

class CreaViaggio2Fragment : Fragment() {

    private var scelta1: Boolean = false
    private var scelta2: Boolean = false
    private var scelta3: Boolean = false
    private var scelta4: Boolean = false
    private var scelta5: Boolean = false
    private var scelta6: Boolean = false
    private var scelta7: Boolean = false
    private var scelta8: Boolean = false
    private var scelta9: Boolean = false
    private var scelta10: Boolean = false

    private var descrizione: String = ""
    private var partecipanti: Int = 0

    private lateinit var checkBox1: MaterialCheckBox
    private lateinit var checkBox2: MaterialCheckBox
    private lateinit var checkBox3: MaterialCheckBox
    private lateinit var checkBox4: MaterialCheckBox
    private lateinit var checkBox5: MaterialCheckBox
    private lateinit var checkBox6: MaterialCheckBox
    private lateinit var checkBox7: MaterialCheckBox
    private lateinit var checkBox8: MaterialCheckBox
    private lateinit var checkBox9: MaterialCheckBox
    private lateinit var checkBox10: MaterialCheckBox

    private lateinit var descrizioneBox: EditText
    private lateinit var partecipantiBox: EditText

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = requireActivity().getSharedPreferences("CreaViaggio2Prefs", Context.MODE_PRIVATE)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_crea_viaggio2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Restore the data from SharedPreferences
        restoreState()

        // Set all the variables
        checkBox1 = view.findViewById(R.id.scelta1)
        checkBox1.isChecked = scelta1
        checkBox2 = view.findViewById(R.id.scelta2)
        checkBox2.isChecked = scelta2
        checkBox3 = view.findViewById(R.id.scelta3)
        checkBox3.isChecked = scelta3
        checkBox4 = view.findViewById(R.id.scelta4)
        checkBox4.isChecked = scelta4
        checkBox5 = view.findViewById(R.id.scelta5)
        checkBox5.isChecked = scelta5
        checkBox6 = view.findViewById(R.id.scelta6)
        checkBox6.isChecked = scelta6
        checkBox7 = view.findViewById(R.id.scelta7)
        checkBox7.isChecked = scelta7
        checkBox8 = view.findViewById(R.id.scelta8)
        checkBox8.isChecked = scelta8
        checkBox9 = view.findViewById(R.id.scelta9)
        checkBox9.isChecked = scelta9
        checkBox10 = view.findViewById(R.id.scelta10)
        checkBox10.isChecked = scelta10
        descrizioneBox = view.findViewById(R.id.textArea)
        descrizioneBox.setText(descrizione)
        partecipantiBox = view.findViewById(R.id.partecipanti)
        partecipantiBox.setText(partecipanti.toString())

        // Set the text for the toolbar
        val title = view.findViewById<TextView>(R.id.toolbar_title)
        title.text = "Crea Viaggio"

        val navController = findNavController()

        val indietroBtn = view.findViewById<MaterialButton>(R.id.indietro_btn)
        indietroBtn.setOnClickListener {
            // Save the state before navigating up
            saveState()
            navController.navigateUp()
        }
    }

    private fun saveState() {
        val editor = sharedPreferences.edit()
        editor.putBoolean("scelta1", checkBox1.isChecked)
        editor.putBoolean("scelta2", checkBox2.isChecked)
        editor.putBoolean("scelta3", checkBox3.isChecked)
        editor.putBoolean("scelta4", checkBox4.isChecked)
        editor.putBoolean("scelta5", checkBox5.isChecked)
        editor.putBoolean("scelta6", checkBox6.isChecked)
        editor.putBoolean("scelta7", checkBox7.isChecked)
        editor.putBoolean("scelta8", checkBox8.isChecked)
        editor.putBoolean("scelta9", checkBox9.isChecked)
        editor.putBoolean("scelta10", checkBox10.isChecked)
        editor.putString("descrizione", descrizioneBox.text.toString())
        editor.putInt("partecipanti", partecipantiBox.text.toString().toInt())
        editor.apply()
    }

    private fun restoreState() {
        scelta1 = sharedPreferences.getBoolean("scelta1", false)
        scelta2 = sharedPreferences.getBoolean("scelta2", false)
        scelta3 = sharedPreferences.getBoolean("scelta3", false)
        scelta4 = sharedPreferences.getBoolean("scelta4", false)
        scelta5 = sharedPreferences.getBoolean("scelta5", false)
        scelta6 = sharedPreferences.getBoolean("scelta6", false)
        scelta7 = sharedPreferences.getBoolean("scelta7", false)
        scelta8 = sharedPreferences.getBoolean("scelta8", false)
        scelta9 = sharedPreferences.getBoolean("scelta9", false)
        scelta10 = sharedPreferences.getBoolean("scelta10", false)
        descrizione = sharedPreferences.getString("descrizione", "") ?: ""
        partecipanti = sharedPreferences.getInt("partecipanti", 0)
    }
}