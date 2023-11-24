package com.example.betsmart

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageViewLogo = findViewById<ImageView>(R.id.imageViewLogo)
        val btnIniciar = findViewById<Button>(R.id.btnIniciar)

        imageViewLogo.setImageResource(R.drawable.smartbet)

        // Adicione a lógica de clique no botão
        btnIniciar.setOnClickListener {
            // Iniciar a nova atividade aqui
            val intent = Intent(this, SegundaActivity::class.java)
            startActivity(intent)
        }
    }
}
