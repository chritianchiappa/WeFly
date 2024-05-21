//package com.example.wefly
//
//import android.os.Bundle
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
//import androidx.fragment.app.Fragment
//import androidx.navigation.findNavController
//import androidx.navigation.ui.setupWithNavController
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.wefly.databinding.ActivityMainBinding
//import com.google.android.material.bottomnavigation.BottomNavigationView
//
//class MainActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityMainBinding
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//        val navView:BottomNavigationView = binding.navView
//        val navController = findNavController(R.id.nav_host_fragment_activity_main)
//        navView.setupWithNavController(navController)
//
//        replaceFragment(ViaggiFragment())
//    }
//    private fun replaceFragment(homeFragment: Fragment){
//        val fragmentManager = supportFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.fragment_viaggi_layout, homeFragment)
//        fragmentTransaction.commit()
//    }
//}






package com.example.wefly

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wefly.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val navView:BottomNavigationView = binding.bottomNavigation
        val navController = findNavController(R.id.nav_host_fragment_main_activity)
        navView.setupWithNavController(navController)

        replaceFragment(ViaggiFragment())
    }
    private fun replaceFragment(homeFragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_viaggi_layout, homeFragment)
        fragmentTransaction.commit()
    }
}

