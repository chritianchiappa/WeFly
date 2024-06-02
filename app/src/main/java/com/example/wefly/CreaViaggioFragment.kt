package com.example.wefly

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import com.google.android.material.datepicker.MaterialDatePicker
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import java.io.BufferedReader
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone
import java.io.InputStreamReader


class CreaViaggioFragment : Fragment() {

    // dichiarazione dataPickerBtn
    private lateinit var dataPickerBtn : MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Clear state when the app starts
        clearFragmentState()

    }

    override fun onResume() {
        super.onResume()

        val listCitta = readCSVFile()

        //creating an arrayList of only cities
        val listCities = listCitta.map { "${it.citta} - ${it.nazione}" }.toTypedArray()

        // val cities = resources.getStringArray(R.array.cities)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, listCities)
        val autoCompleteTextView = view?.findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        autoCompleteTextView?.setAdapter(arrayAdapter)

        // Add an onItemClickListener to get the selected value
        autoCompleteTextView?.onItemClickListener = AdapterView.OnItemClickListener { parent, _, position, _ ->
            val selectedCityNation = parent.getItemAtPosition(position).toString()
            val parts = selectedCityNation.split(" - ") // Split the string by the hyphen
            val nation = parts[1].trim() // Get the second part (nation) and trim whitespace

            val nationText = view?.findViewById<TextView>(R.id.nazione_txt)
            nationText?.text = nation

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_crea_viaggio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //inflate the layout for dataPickerBtn
        dataPickerBtn = view.findViewById(R.id.data_picker_btn)

        dataPickerBtn.setOnClickListener {
            val picker = MaterialDatePicker.Builder.dateRangePicker()
                .setTheme(R.style.ThemeMaterialCalendar)
                .setTitleText("Seleziona la data")
                .build()

            picker.show(this.parentFragmentManager, "TAG")

            picker.addOnPositiveButtonClickListener {
                    selection ->
                val startDateMillis = selection.first
                val endDateMillis = selection.second

                // Convert milliseconds to Calendar objects
                val startDateCalendar = Calendar.getInstance().apply {
                    timeInMillis = startDateMillis
                }
                val endDateCalendar = Calendar.getInstance().apply {
                    timeInMillis = endDateMillis
                }

                // Extract day, month, and year from Calendar objects
                val dateStartDay = startDateCalendar.get(Calendar.DAY_OF_MONTH)
                val dateStartMonth = startDateCalendar.get(Calendar.MONTH) + 1
                val dateStartYear = startDateCalendar.get(Calendar.YEAR)

                val dateEndDay = endDateCalendar.get(Calendar.DAY_OF_MONTH)
                val dateEndMonth = endDateCalendar.get(Calendar.MONTH) + 1
                val dateEndYear = endDateCalendar.get(Calendar.YEAR)

                Log.d("SendMessage", "Ricevuta $dateStartDay/$dateStartMonth/$dateStartYear")
                Log.d("SendMessage", "Ricevuta $dateEndDay/$dateEndMonth/$dateEndYear")
            }

            picker.addOnNegativeButtonClickListener{
                picker.dismiss()
            }
        }

        val title = view.findViewById<TextView>(R.id.toolbar_title)
        title.text = "Crea Viaggio"

        val navController = findNavController()

        val avantiBtn = view.findViewById<MaterialButton>(R.id.avanti_btn)
        avantiBtn.setOnClickListener {

            navController.navigate(R.id.action_navigation_crea_viaggio_to_creaViaggio2Fragment)
        }
    }

    private fun readCSVFile(): List<DataCitta> {
        val inputStream = requireContext().assets.open("cities.csv")
        val bufferReader = BufferedReader(InputStreamReader(inputStream))
        val csvParser = CSVParser.parse(bufferReader, CSVFormat.DEFAULT)

        val listCitta = mutableListOf<DataCitta>()
        csvParser.forEach {
            it?.let{
                val citta = DataCitta(
                    citta = it.get(0),
                    nazione = it.get(1),
                    lat = it.get(2).toDouble(),
                    lng= it.get(3).toDouble(),
                    popolazione= it.get(4).toInt(),
                    capitale = it.get(5)
                )
                listCitta.add(citta)
            }
        }

        return listCitta

    }

    private fun clearFragmentState() {
        val sharedPreferences = requireActivity().getSharedPreferences("CreaViaggio2Prefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

    private fun convertTimeToDate(time: Long): String {
        val utc = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
        utc.timeInMillis = time
        val format = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return format.format((utc.time))
    }


}