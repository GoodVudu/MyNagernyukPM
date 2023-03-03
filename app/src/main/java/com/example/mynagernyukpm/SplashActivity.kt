package com.example.mynagernyukpm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.content.Intent

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val storage = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)

        val login = storage.getString("Login",null)

        val number = storage.getString("Number",null)

        val password = storage.getString("Password",null)
        val autoLoginFlag = storage.getBoolean("AutoLoginFlag", false)


        if (login == null &&  number == null)
        {
            val intent = Intent(this,RegistrationActivity::class.java)
            startActivity(intent)
        }
        /*else if (password == null)
        {
            val intent = Intent(this,RegistrationActivity::class.java)
            startActivity(intent)
        }*/
        else if ( login != null || number != null)
        {
            if(autoLoginFlag == false){
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            }
            else {
                val intent = Intent(this,ContentActivity::class.java)
                startActivity(intent)
            }
        }









    }
}