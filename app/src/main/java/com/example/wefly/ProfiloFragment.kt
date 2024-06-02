package com.example.wefly

import android.app.Dialog
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.example.wefly.databinding.FragmentProfiloBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import androidx.exifinterface.media.ExifInterface
import java.io.File

class ProfiloFragment : Fragment() {

    private lateinit var binding: FragmentProfiloBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    private lateinit var storageReference: StorageReference
    private lateinit var utente: DataUtenti
    private lateinit var uid: String

    // variable for all the interests of the user
    private lateinit var listaInteressi: Array<Boolean>
    private lateinit var interessiString: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout using the binding variable
        binding = FragmentProfiloBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()
        uid = auth.currentUser?.uid.toString()

        databaseReference = FirebaseDatabase.getInstance("https://wefly-d50f7-default-rtdb.europe-west1.firebasedatabase.app").getReference("Utenti")
        if(uid.isNotEmpty()){
            getUserData()
        }

        //set the text for the tool bar
        val title = view.findViewById<TextView>(R.id.toolbar_title)
        title.text = "Profilo"

        val viaggiAttualiBtn = view.findViewById<MaterialButton>(R.id.viaggi_attuali_btn)
        viaggiAttualiBtn.setOnClickListener {
            val intentViaggiAttuali = Intent(context, ViaggiAttualiActivity::class.java)
            startActivity(intentViaggiAttuali)
        }

        val viaggiPassatiBtn = view.findViewById<MaterialButton>(R.id.viaggi_passati_btn)
        viaggiPassatiBtn.setOnClickListener {
            val intentViaggiPassati = Intent(context, ViaggiPassatiActivity::class.java)
            startActivity(intentViaggiPassati)
        }
    }

    private fun getUserData(){

        Toast.makeText(context, "Caricamento dati...", Toast.LENGTH_SHORT).show()
        databaseReference.child(uid).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                utente = snapshot.getValue(DataUtenti::class.java)!!
                binding.nomeUtente.text = utente.nome
                binding.cognomeUtente.text = utente.cognome
                getInteressi()
                getUserProfile()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "Impossibile caricare dati", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun getInteressi(){
        var interessi = ""
        interessiString = arrayListOf<String>()

        listaInteressi = arrayOf(
            utente.scelta1 ?: false,
            utente.scelta2 ?: false,
            utente.scelta3 ?: false,
            utente.scelta4 ?: false,
            utente.scelta5 ?: false,
            utente.scelta6 ?: false,
            utente.scelta7 ?: false,
            utente.scelta8 ?: false,
            utente.scelta9 ?: false,
            utente.scelta10 ?: false
        )

        for (i in 0..9) {
            if (listaInteressi[i]) {
                // Get the resource ID dynamically
                val resId = resources.getIdentifier("scelta${i+1}", "string", context?.packageName)

                // Use getString() to get the actual string value
                if (resId != 0) {
                    val interesse = getString(resId)
                    interessi += "$interesse"
                    interessiString.add("$interesse")
                }
                if(i != 9){
                    interessi += ", "
                }
            }
        }

        binding.interessiUtente.setText(interessi)
    }

    private fun getUserProfile(){
        storageReference = FirebaseStorage.getInstance().reference.child("Utenti/$uid.jpg")
        val localFile = File.createTempFile("tempimage","jpg")
        storageReference.getFile(localFile).addOnSuccessListener {
            val bitmap = BitmapFactory.decodeFile(localFile.absolutePath)
            val rotatedBitmap = rotateImageIfRequired(bitmap, localFile.absolutePath)
            binding.profilePicture.setImageBitmap(rotatedBitmap)
        }.addOnFailureListener{
            Toast.makeText(context, "Impossibile caricare l'immagine", Toast.LENGTH_SHORT).show()
        }
    }

    private fun rotateImageIfRequired(img: Bitmap, filePath: String): Bitmap {
        val ei = ExifInterface(filePath)
        val orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL)

        return when (orientation) {
            ExifInterface.ORIENTATION_ROTATE_90 -> rotateImage(img, 90)
            ExifInterface.ORIENTATION_ROTATE_180 -> rotateImage(img, 180)
            ExifInterface.ORIENTATION_ROTATE_270 -> rotateImage(img, 270)
            else -> img
        }
    }

    private fun rotateImage(img: Bitmap, degree: Int): Bitmap {
        val matrix = Matrix()
        matrix.postRotate(degree.toFloat())
        return Bitmap.createBitmap(img, 0, 0, img.width, img.height, matrix, true)
    }
}