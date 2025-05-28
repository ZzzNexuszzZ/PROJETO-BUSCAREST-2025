package com.example.buscarest

import android.content.Intent // <--- IMPORT NECESSÁRIO
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RestauranteAdapter(private val restaurantes: List<Restaurante>) :
    RecyclerView.Adapter<RestauranteAdapter.RestauranteViewHolder>() {

    class RestauranteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nome: TextView = view.findViewById(R.id.txtNome)
        val categoria: TextView = view.findViewById(R.id.txtCategoria)
        val imagem: ImageView = view.findViewById(R.id.imgRestaurante)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestauranteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_restaurante, parent, false)
        return RestauranteViewHolder(view)
    }

    override fun onBindViewHolder(holder: RestauranteViewHolder, position: Int) {
        val restaurante = restaurantes[position]

        holder.nome.text = restaurante.nomeRes
        holder.categoria.text = restaurante.categoria
        holder.imagem.setImageResource(restaurante.imagemResIdRes)

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetalhesRestauranteActivity::class.java)
            intent.putExtra("restaurante", restaurante)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = restaurantes.size
}
