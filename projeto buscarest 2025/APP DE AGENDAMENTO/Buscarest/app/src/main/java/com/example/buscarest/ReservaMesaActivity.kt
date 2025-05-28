package com.example.buscarest

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalTime
import java.util.*

class ReservaMesaActivity : AppCompatActivity() {

    private lateinit var etNome: EditText
    private lateinit var etEmail: EditText
    private lateinit var etData: EditText
    private lateinit var etHorario: EditText
    private lateinit var etNumeroPessoas: EditText
    private lateinit var btnContinuar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reserva_mesa)

        // Recebendo os dados do restaurante selecionado
        val nomeRestaurante = intent.getStringExtra("nomeRestaurante") ?: "Restaurante"
        val imagemRestaurante = intent.getIntExtra("imagemRestaurante", R.drawable.ic_launcher_background)
        val horarioAbertura = intent.getStringExtra("horarioAbertura") ?: "10:00"
        val horarioFechamento = intent.getStringExtra("horarioFechamento") ?: "22:00"

        // Atualiza a interface com os dados do restaurante
        findViewById<TextView>(R.id.txtNomeRestaurante).text = nomeRestaurante
        findViewById<ImageView>(R.id.imgRestaurante).setImageResource(imagemRestaurante)

        // Inicialização dos componentes
        etNome = findViewById(R.id.etNome)
        etEmail = findViewById(R.id.etEmail)
        etData = findViewById(R.id.etData)
        etHorario = findViewById(R.id.etHorario)
        etNumeroPessoas = findViewById(R.id.etNumeroPessoas)
        btnContinuar = findViewById(R.id.btnContinuar)

        // DatePicker para selecionar data
        etData.setOnClickListener {
            val calendar = Calendar.getInstance()
            DatePickerDialog(
                this,
                { _, year, month, dayOfMonth ->
                    val dataFormatada = String.format("%02d/%02d/%04d", dayOfMonth, month + 1, year)
                    etData.setText(dataFormatada)
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        // TimePicker para selecionar horário
        etHorario.setOnClickListener {
            val calendar = Calendar.getInstance()
            TimePickerDialog(
                this,
                { _, hourOfDay, minute ->
                    val horaFormatada = String.format("%02d:%02d", hourOfDay, minute)
                    etHorario.setText(horaFormatada)
                },
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                true // formato 24h
            ).show()
        }

        // Ao clicar no botão Continuar
        btnContinuar.setOnClickListener {
            if (validarCampos()) {
                val nome = etNome.text.toString()
                val email = etEmail.text.toString()
                val data = etData.text.toString()
                val horario = etHorario.text.toString()
                val numPessoas = etNumeroPessoas.text.toString()

                try {
                    val horarioReserva = LocalTime.parse(horario)
                    val abertura = LocalTime.parse(horarioAbertura)
                    val fechamento = LocalTime.parse(horarioFechamento)

                    if (podeReservar(horarioReserva, abertura, fechamento)) {
                        val intent = Intent(this, ConfirmacaoReservaActivity::class.java).apply {
                            putExtra("nome", nome)
                            putExtra("email", email)
                            putExtra("data", data)
                            putExtra("horario", horario)
                            putExtra("numeroPessoas", numPessoas)
                            putExtra("nomeRestaurante", nomeRestaurante)
                            putExtra("imagemRestaurante", imagemRestaurante)
                        }
                        startActivity(intent)
                    } else {
                        Toast.makeText(
                            this,
                            "Este restaurante só aceita reservas entre $horarioAbertura e $horarioFechamento.",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                } catch (e: Exception) {
                    Toast.makeText(this, "Horário inválido.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    // Validação dos campos obrigatórios
    private fun validarCampos(): Boolean {
        return when {
            etNome.text.isNullOrBlank() ||
                    etEmail.text.isNullOrBlank() ||
                    etData.text.isNullOrBlank() ||
                    etHorario.text.isNullOrBlank() ||
                    etNumeroPessoas.text.isNullOrBlank() -> {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
                false
            }
            !isValidEmail(etEmail.text.toString()) -> {
                Toast.makeText(this, "E-mail inválido!", Toast.LENGTH_SHORT).show()
                false
            }
            else -> true
        }
    }

    // Verifica se o horário da reserva está dentro do horário de funcionamento
    private fun podeReservar(horarioReserva: LocalTime, abertura: LocalTime, fechamento: LocalTime): Boolean {
        return !horarioReserva.isBefore(abertura) && !horarioReserva.isAfter(fechamento)
    }

    // Validador simples de e-mail
    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
