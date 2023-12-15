package com.example.appgarcon

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity() : AppCompatActivity() {

    lateinit var txtCodigo : EditText
    lateinit var btnLogin : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin  = findViewById<Button>(R.id.btnLogin)
        txtCodigo = findViewById<EditText>(R.id.edtCliente)
    }


    fun login(view: View) {

        val cliente = ConexaoDB.ConsultaCNPJ(txtCodigo.text.toString())

        if(cliente != null) {

            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            builder
                .setMessage(cliente)
                .setTitle("Bem Vindo")
                .setPositiveButton("OK") { dialog, which ->
                    val menuapp = Intent(this,MenuApp::class.java)
                    startActivity(menuapp)
                }

            val dialog: AlertDialog = builder.create()
            dialog.show()
        } else {

            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            builder
                .setMessage("Cliente Não Encontrado...")
                .setTitle("Atenção")
                .setPositiveButton("OK") { dialog, which ->
                    txtCodigo.focusable
                }

            val dialog: AlertDialog = builder.create()
            dialog.show()
        }

    }

}