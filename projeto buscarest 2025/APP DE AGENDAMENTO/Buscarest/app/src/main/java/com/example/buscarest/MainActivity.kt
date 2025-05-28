package com.example.buscarest
import com.example.buscarest.SelecaoRestauranteActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnComecar = findViewById<Button>(R.id.btnComecar)
        btnComecar.setOnClickListener {
            val intent = Intent(this, SelecaoRestauranteActivity ::class.java)
            startActivity(intent)
        }
    }
    override fun onResume() {
        super.onResume()
        val intent = intent
        intent.removeExtra("NOME")
        intent.removeExtra("EMAIL")
        intent.removeExtra("DATA")
        intent.removeExtra("HORARIO")
        intent.removeExtra("PESSOAS")
    }
}