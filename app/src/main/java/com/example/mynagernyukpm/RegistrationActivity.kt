package com.example.mynagernyukpm

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)



        val storage = getSharedPreferences("settings", MODE_PRIVATE)


        val edText1 = findViewById<EditText>(R.id.edTextLogin1) //Login
        val edText2 = findViewById<EditText>(R.id.edText2) //Password
        val edText3 = findViewById<EditText>(R.id.edText3) //Password again

        val buttonEmail = findViewById<Button>(R.id.button3)
        val buttonNumber = findViewById<Button>(R.id.button2)

        val registButton = findViewById<Button>(R.id.button)

        var accessTypeFlag = 1


        fun saveData(){
            val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.apply{
                putString("Login",edText1.text.toString())
                putString("Password",edText2.text.toString())
            }.apply()
        }

        buttonEmail.setOnClickListener {
            buttonEmail.setTextColor(resources.getColor(R.color.purple_500))
            buttonNumber.setTextColor(resources.getColor(R.color.black))
            edText1.hint = "Введите email"
            edText1.inputType = 21
            accessTypeFlag = 1
        }

        buttonNumber.setOnClickListener {
            buttonNumber.setTextColor(resources.getColor(R.color.purple_500))
            buttonEmail.setTextColor(resources.getColor(R.color.black))
            edText1.hint = "Введите номер"
            edText1.inputType = 2
            accessTypeFlag = 0 //New Flag
        }

        registButton.setOnClickListener {
            val loginText1 = edText1.text.toString()
            val passwordText1 = edText2.text.toString()
            val passwordAcces1 = edText3.text.toString()

            if (accessTypeFlag == 1) {
                if (!loginText1.contains("@")) {
                    Toast.makeText(
                        this,
                        "Неправильно введен Email, повторите попытку снова",
                        Toast.LENGTH_LONG
                    ).show()
                    return@setOnClickListener
                }
            }
            if (accessTypeFlag == 0){
                if (!loginText1.contains("+")) {
                    Toast.makeText(
                        this,
                        "Неправильно введен номер телефона, повторите попытку снова",
                        Toast.LENGTH_LONG
                    ).show()
                    return@setOnClickListener
                }

            }
            if (passwordText1.length < 8){
                Toast.makeText(this,"Неправильно введен пароль, минимум 8 символов",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (!passwordText1.equals(passwordAcces1)){
                Toast.makeText(this,"Пароли не совпадают, повторите попытку снова",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            saveData()

            val intent = Intent(this,ContentActivity::class.java)
            // intent.putExtra("Login",loginText1)
            //storage.edit().putString("Login",loginText1).apply()
            startActivity(intent)





        }
    }
}