package com.example.buscarest

import java.io.Serializable

data class Prato(
    val idPrato: Int,
    val nome: String,
    val descricao: String,
    val preco: Double,
    val imagemUrl: String
) : Serializable
