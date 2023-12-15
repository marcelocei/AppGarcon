package com.example.appgarcon

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuApp : AppCompatActivity() {

    lateinit var btnSair : Button
    lateinit var btnAtendimento : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_app)


        btnAtendimento = findViewById(R.id.btnAtendimento)
        btnSair = findViewById(R.id.btnSair)

        btnAtendimento.setOnClickListener {

            val atendimento = Intent(this,Atendimentos::class.java)
            startActivity(atendimento)
        }

        btnSair.setOnClickListener{
             finishAffinity()
        }

    }
}