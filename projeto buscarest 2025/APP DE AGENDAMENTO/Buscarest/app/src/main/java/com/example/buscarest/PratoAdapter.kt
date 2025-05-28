package com.example.buscarest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide



class PratoAdapter(private val pratos: List<Prato>) :
    RecyclerView.Adapter<PratoAdapter.PratoViewHolder>() {

    inner class PratoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nome = view.findViewById<TextView>(R.id.nomePrato)
        val descricao = view.findViewById<TextView>(R.id.descricaoPrato)
        val preco = view.findViewById<TextView>(R.id.precoPrato)
        val imagem = view.findViewById<ImageView>(R.id.imagemPrato)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PratoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_prato, parent, false)
        return PratoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PratoViewHolder, position: Int) {
        val prato = pratos[position]
        holder.nome.text = prato.nome
        holder.descricao.text = prato.descricao
        holder.preco.text = "R$ %.2f".format(prato.preco)
        Glide.with(holder.itemView.context).load(prato.imagemUrl).into(holder.imagem)
    }

    override fun getItemCount() = pratos.size
}
