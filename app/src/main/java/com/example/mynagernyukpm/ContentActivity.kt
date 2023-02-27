package com.example.mynagernyukpm

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class ContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)


        val Text1 = findViewById<TextView>(R.id.textView)

        fun loadData(){
            val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
            val savedLogin = sharedPreferences.getString("Login",null)
            val savedPassword = sharedPreferences.getString("Password",null)

            Text1.text = savedLogin
        }

        loadData()
    }
}