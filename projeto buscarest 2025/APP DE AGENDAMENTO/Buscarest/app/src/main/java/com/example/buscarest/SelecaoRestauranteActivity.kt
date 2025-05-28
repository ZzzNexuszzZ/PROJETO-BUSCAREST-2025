package com.example.buscarest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SelecaoRestauranteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selecao_restaurante)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewRestaurantes)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val listaRestaurantes = listOf(
            Restaurante(
                idRes = 1,
                nomeRes = "Sushi Place",
                descricaoRes = "Restaurante especializado em comida japonesa.",
                imagens = listOf("https://exemplo.com/sushi1.png", "https://exemplo.com/sushi2.png"),
                pratos = listOf(
                    Prato(1, "Sushi Salmão", "Fatias frescas de salmão", 42.90, "https://exemplo.com/sushi.png"),
                    Prato(2, "Temaki Atum", "Temaki recheado com atum fresco", 35.00, "https://exemplo.com/temaki.png"),
                    Prato(3, "Yakissoba", "Macarrão oriental com legumes e carne", 39.90, "https://exemplo.com/yakissoba.png")
                ),
                horarioAberturaRes = "11:00",
                horarioFechamentoRes = "22:00",
                telefone = "11 98765-4321",
                endereco = "Rua das Flores, 123",
                categoria = "Comida Japonesa",
                imagemResIdRes = R.drawable.sushi
            ),
            Restaurante(
                idRes = 2,
                nomeRes = "Pizzaria Itália",
                descricaoRes = "Pizzas artesanais com ingredientes frescos.",
                imagens = listOf("https://exemplo.com/pizza1.png"),
                pratos = listOf(
                    Prato(4, "Pizza Margherita", "Molho de tomate, mussarela e manjericão", 39.90, "https://exemplo.com/pizza.png"),
                    Prato(5, "Pizza Quatro Queijos", "Mussarela, parmesão, gorgonzola e provolone", 45.50, "https://exemplo.com/queijos.png"),
                    Prato(6, "Pizza Pepperoni", "Pepperoni com queijo derretido", 42.00, "https://exemplo.com/pepperoni.png")
                ),
                horarioAberturaRes = "18:00",
                horarioFechamentoRes = "23:30",
                telefone = "11 91234-5678",
                endereco = "Av. Itália, 456",
                categoria = "Pizzaria",
                imagemResIdRes = R.drawable.pizza
            ),
            Restaurante(
                idRes = 3,
                nomeRes = "Burger House",
                descricaoRes = "Os melhores hambúrgueres da cidade.",
                imagens = listOf("https://exemplo.com/burger1.png"),
                pratos = listOf(
                    Prato(7, "Cheeseburguer", "Pão, carne, queijo e molho especial", 29.90, "https://exemplo.com/burger.png"),
                    Prato(8, "Double Bacon", "Duas carnes, bacon e cheddar", 34.90, "https://exemplo.com/bacon.png"),
                    Prato(9, "Veggie Burguer", "Hambúrguer vegetariano com salada", 28.00, "https://exemplo.com/veggie.png")
                ),
                horarioAberturaRes = "10:00",
                horarioFechamentoRes = "23:00",
                telefone = "11 99876-5432",
                endereco = "Av. Central, 789",
                categoria = "Fast Food",
                imagemResIdRes = R.drawable.burger
            ),
            Restaurante(
                idRes = 4,
                nomeRes = "Cantina Bella Pasta",
                descricaoRes = "Massas italianas autênticas e feitas na hora.",
                imagens = listOf("https://exemplo.com/pasta1.png"),
                pratos = listOf(
                    Prato(10, "Spaghetti à Bolonhesa", "Com molho de carne caseiro", 38.90, "https://exemplo.com/bolonhesa.png"),
                    Prato(11, "Fettuccine Alfredo", "Com molho cremoso de parmesão", 41.90, "https://exemplo.com/alfredo.png"),
                    Prato(12, "Lasanha de Frango", "Recheada com frango e queijo", 44.00, "https://exemplo.com/lasanha.png")
                ),
                horarioAberturaRes = "12:00",
                horarioFechamentoRes = "22:00",
                telefone = "11 93333-1111",
                endereco = "Rua das Massas, 321",
                categoria = "Italiana",
                imagemResIdRes = R.drawable.pasta
            ),
            Restaurante(
                idRes = 5,
                nomeRes = "Sabores do Sertão",
                descricaoRes = "Comida típica nordestina com sabor caseiro.",
                imagens = listOf("https://exemplo.com/baiao1.png"),
                pratos = listOf(
                    Prato(13, "Baião de Dois", "Arroz com feijão verde, queijo coalho e carne seca", 32.50, "https://exemplo.com/baiao.png"),
                    Prato(14, "Carne de Sol com Macaxeira", "Servida com manteiga de garrafa", 36.90, "https://exemplo.com/macaxeira.png"),
                    Prato(15, "Moqueca de Peixe", "Peixe cozido no leite de coco e dendê", 40.00, "https://exemplo.com/moqueca.png")
                ),
                horarioAberturaRes = "11:30",
                horarioFechamentoRes = "21:30",
                telefone = "11 94444-2222",
                endereco = "Rua do Sertão, 654",
                categoria = "Nordestina",
                imagemResIdRes = R.drawable.sertao
            ),
            Restaurante(
                idRes = 6,
                nomeRes = "Delícias Árabes",
                descricaoRes = "Tradição e sabor da culinária do Oriente Médio.",
                imagens = listOf("https://exemplo.com/kibe1.png"),
                pratos = listOf(
                    Prato(16, "Esfiha de Carne", "Fechada com carne temperada", 6.00, "https://exemplo.com/esfiha.png"),
                    Prato(17, "Kibe Frito", "Bolinhos crocantes de carne e trigo", 7.50, "https://exemplo.com/kibe.png"),
                    Prato(18, "Tabule", "Salada refrescante de trigo, tomate e hortelã", 10.00, "https://exemplo.com/tabule.png")
                ),
                horarioAberturaRes = "10:30",
                horarioFechamentoRes = "20:30",
                telefone = "11 95555-3333",
                endereco = "Rua do Oriente, 888",
                categoria = "Árabe",
                imagemResIdRes = R.drawable.arabe
            )
        )


        recyclerView.adapter = RestauranteAdapter(listaRestaurantes)
    }
}
