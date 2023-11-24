package com.example.betsmart

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SegundaActivity : AppCompatActivity() {

    private var resposta: String? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.segunda_activity)

        val btnOpcao1 = findViewById<Button>(R.id.btnOpcao1)
        val btnOpcao2 = findViewById<Button>(R.id.btnOpcao2)
        val btnOpcao5 = findViewById<Button>(R.id.btnOpcao5)

        val tvPergunta = findViewById<TextView>(R.id.tvPergunta)

        exibirPerguntaAtual()

        btnOpcao1.setOnClickListener {
            salvarResposta("Opção 1 selecionada")
            irParaProximaAtividade()
        }

        btnOpcao2.setOnClickListener {
            salvarResposta("Opção 2 selecionada")
            irParaProximaAtividade()
        }

        btnOpcao5.setOnClickListener {
            salvarResposta("Opção 3 selecionada")
            irParaProximaAtividade()
        }
    }

    private fun exibirPerguntaAtual() {
        val perguntaAtual = "VOCÊ JÁ ATUA OU JÁ ATUOU NO MERCADO DE APOSTAS?"
        findViewById<TextView>(R.id.tvPergunta).text = perguntaAtual
    }

    private fun salvarResposta(resposta: String) {
        this.resposta = resposta
    }

    private fun irParaProximaAtividade() {
        // Passar para a próxima atividade, levando a resposta junto
        val intent = Intent(this, ProximaAtividade::class.java)
        intent.putExtra("resposta", resposta)
        startActivity(intent)
    }
}
