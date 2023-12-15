package com.example.appgarcon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appgarcon.databinding.ActivityAtendimentosBinding



class Atendimentos : AppCompatActivity() {

    private lateinit var binding : ActivityAtendimentosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAtendimentosBinding.inflate(layoutInflater)

        setContentView(binding.root)

        InicializaRecycleView()
    }

    private fun InicializaRecycleView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = AdapterAtendimento(ListaAtendimento())
    }

//    private fun ListaAtendimento() = listOf(
//        "ab","bdd","ggg","ghjk","ttt"
//    )

    private fun ListaAtendimento() = ConexaoDB.ListaAtendimentos()
}