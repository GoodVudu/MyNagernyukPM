package com.example.mynagernyukpm

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class ContentActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        val bottom_nav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
       // val Text1 = findViewById<TextView>(R.id.textView)
        bottom_nav.setupWithNavController(navController)


        /*fun loadData(){
            val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
            val savedLogin = sharedPreferences.getString("Login",null)
            val savedPassword = sharedPreferences.getString("Password",null)
        }*/

        //loadData()
    }
}