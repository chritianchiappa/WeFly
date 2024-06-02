package com.example.wefly

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.wefly.databinding.ActivitySignInBinding
import com.example.wefly.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        binding.continuaBtn.setOnClickListener{
            //send all the data to the next activity
            val intent = Intent(this, CompletaProfiloActivity::class.java)
            intent.putExtra("nome", binding.editTextNome.text.toString())
            intent.putExtra("cognome", binding.editTextCognome.text.toString())
            intent.putExtra("telefono", binding.editTextTelefono.text.toString())
            intent.putExtra("email", binding.editTextEmail.text.toString())
            intent.putExtra("password", binding.editTextPassword.text.toString())

            startActivity(intent)
        }

        var goBackBtn = findViewById<ImageView>(R.id.go_back)
        goBackBtn.setOnClickListener {
            val intentGoBack = Intent(this, RegisterActivity::class.java)
            intentGoBack.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intentGoBack)
        }



    }
}