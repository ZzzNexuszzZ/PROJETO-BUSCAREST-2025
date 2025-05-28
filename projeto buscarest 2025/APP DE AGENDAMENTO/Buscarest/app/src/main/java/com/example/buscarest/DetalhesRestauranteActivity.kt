package com.example.buscarest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DetalhesRestauranteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_restaurante)

        val restaurante = intent.getSerializableExtra("restaurante") as? Restaurante

        restaurante?.let { restaurante ->
            findViewById<ImageView>(R.id.imagemRestaurante).setImageResource(restaurante.imagemResIdRes)
            findViewById<TextView>(R.id.nomeRestaurante).text = restaurante.nomeRes
            findViewById<TextView>(R.id.categoriaRestaurante).text = restaurante.categoria
            findViewById<TextView>(R.id.enderecoRestaurante).text =
                "Endereço: ${restaurante.endereco}"
            findViewById<TextView>(R.id.telefoneRestaurante).text =
                "Telefone: ${restaurante.telefone}"
            findViewById<TextView>(R.id.horarioRestaurante).text =
                "Funcionamento: ${restaurante.horarioAberturaRes} às ${restaurante.horarioFechamentoRes}"

            val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewPratos)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = PratoAdapter(restaurante.pratos)

            findViewById<Button>(R.id.btnFazerReserva).setOnClickListener {
                val intent = Intent(this, ReservaMesaActivity::class.java).apply {
                    putExtra("nomeRestaurante", restaurante.nomeRes)
                    putExtra("imagemRestaurante", restaurante.imagemResIdRes)
                    putExtra("horarioAbertura", restaurante.horarioAberturaRes)
                    putExtra("horarioFechamento", restaurante.horarioFechamentoRes)
                }
                startActivity(intent)
            }
        }
    }}