package com.example.buscarest

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConfirmacaoReservaActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmacao_reserva)

        // Referência aos elementos da interface
        val imgRestaurante = findViewById<ImageView>(R.id.imgRestaurante)
        val txtNomeRestaurante = findViewById<TextView>(R.id.txtNomeRestaurante)
        val txtResumoReserva = findViewById<TextView>(R.id.txtResumoReserva)

        // Recuperando os dados enviados via Intent
        val nome = intent.getStringExtra("nome")
        val email = intent.getStringExtra("email")
        val data = intent.getStringExtra("data")
        val horario = intent.getStringExtra("horario")
        val numeroPessoas = intent.getStringExtra("numeroPessoas")
        val nomeRestaurante = intent.getStringExtra("nomeRestaurante") ?: "Restaurante"
        val imagemRestaurante = intent.getIntExtra("imagemRestaurante", R.drawable.ic_launcher_background)

        // Exibindo imagem e nome do restaurante
        imgRestaurante.setImageResource(imagemRestaurante)
        txtNomeRestaurante.text = nomeRestaurante

        // Montando e exibindo o resumo da reserva
        val resumo = """
            Nome: $nome
            E-mail: $email
            Data: $data
            Horário: $horario
            Número de Pessoas: $numeroPessoas
        """.trimIndent()

        txtResumoReserva.text = resumo
    }
}
