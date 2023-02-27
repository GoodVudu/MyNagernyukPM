package com.example.mynagernyukpm

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val edText1 = findViewById<EditText>(R.id.edTextLoginFirst) //Login
        val edText2 = findViewById<EditText>(R.id.edTextLoginSecond) //Password
        val btnLog = findViewById<Button>(R.id.buttonLog)
        val chkBox1 = findViewById<CheckBox>(R.id.checkBoxLog)

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedLogin = sharedPreferences.getString("Login",null)
        val savedPassword = sharedPreferences.getString("Password",null)

        btnLog.setOnClickListener {
            val loginText = edText1.text.toString()
            val passwordText = edText2.text.toString()


            if (loginText == savedLogin && passwordText == savedPassword){
                if (chkBox1.isChecked){
                    sharedPreferences.edit().putBoolean("AutoLoginFlag",true).apply()
                }else{
                    sharedPreferences.edit().putBoolean("AutoLoginFlag",false).apply()
                }
                val intent = Intent(this,ContentActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this,"Неправильно введен логин или пароль, повторите попытку снова", Toast.LENGTH_LONG).show()
            }
        }





    }
}