package com.example.buscarest

import java.io.Serializable

data class Restaurante(
    val idRes: Int,
    val nomeRes: String,
    val descricaoRes: String,
    val imagens: List<String>,
    val pratos: List<Prato>,
    val horarioAberturaRes: String,
    val horarioFechamentoRes: String,
    val telefone: String,
    val endereco: String,
    val categoria: String,
    val imagemResIdRes: Int
) : Serializable
