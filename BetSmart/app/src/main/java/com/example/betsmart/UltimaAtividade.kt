package com.example.betsmart

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class UltimaAtividade : AppCompatActivity() {

    private var resposta: String? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ultima_atividade)

        val btnOpcao1 = findViewById<Button>(R.id.btnInvestir10Percent)
        val btnOpcao2 = findViewById<Button>(R.id.btnInvestir30Percent)
        val btnOpcao3 = findViewById<Button>(R.id.btnInvestir50Percent)

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

        btnOpcao3.setOnClickListener {
            salvarResposta("Opção 3 selecionada")
            irParaProximaAtividade()
        }
    }

    private fun exibirPerguntaAtual() {
        val perguntaAtual = "Quantos % Pretende ter feito 1 Mês Após o Início das Operaçôes?"
        findViewById<TextView>(R.id.tvPergunta).text = perguntaAtual
    }

    private fun salvarResposta(resposta: String) {
        this.resposta = resposta
    }

    private fun irParaProximaAtividade() {
        // Passar para a próxima atividade, levando a resposta junto
        val intent = Intent(this, TelaFinal::class.java)
        intent.putExtra("resposta", resposta)
        startActivity(intent)
    }
}
