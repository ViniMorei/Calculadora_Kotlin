package com.dsdm.myapplication

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

// Imports de componentes necessários
import android.widget.EditText
import android.widget.TextView
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Adicionando os elementos do XML:
        val inputNum1: EditText = findViewById(R.id.txtNro1)
        val inputNum2: EditText = findViewById(R.id.txtNro2)
        val resultado: TextView = findViewById(R.id.txtResultado)

        val btnSomar: Button = findViewById(R.id.btnSomar)
        val btnSubtrair: Button = findViewById(R.id.btnSubtrair)
        val btnMultiplicar: Button = findViewById(R.id.btnMultiplicar)
        val btnDividir: Button = findViewById(R.id.btnDividir)

        // Adicionando event listeners nos botões para
        // eles executarem as funções declaradas
        btnSomar.setOnClickListener() {
            somar(inputNum1, inputNum2, resultado)
        }

        btnSubtrair.setOnClickListener() {
            subtrair(inputNum1, inputNum2, resultado)
        }

        btnMultiplicar.setOnClickListener() {
            multiplicar(inputNum1, inputNum2, resultado)
        }

        btnDividir.setOnClickListener() {
            dividir(inputNum1, inputNum2, resultado)
        }
    }

    // Funções que os botões executam
    fun somar(inputNum1: EditText, inputNum2: EditText, resultado: TextView) {
        val n1: Double = inputNum1.text.toString().toDouble()
        val n2: Double = inputNum2.text.toString().toDouble()

        val res: Double = n1 + n2
        resultado.text = "O resultado é igual a: $res"
        resultado.visibility = View.VISIBLE
    }

    fun subtrair(inputNum1: EditText, inputNum2: EditText, resultado: TextView){
        val n1: Double = inputNum1.text.toString().toDouble()
        val n2: Double = inputNum2.text.toString().toDouble()

        val res: Double = n1 - n2
        resultado.text = "O resultado é igual a: $res"
        resultado.visibility = View.VISIBLE
    }

    fun multiplicar(inputNum1: EditText, inputNum2: EditText, resultado: TextView){
        val n1: Double = inputNum1.text.toString().toDouble()
        val n2: Double = inputNum2.text.toString().toDouble()

        val res: Double = n1 * n2
        resultado.text = "O resultado é igual a: $res"
        resultado.visibility = View.VISIBLE
    }

    fun dividir(inputNum1: EditText, inputNum2: EditText, resultado: TextView){
        val n1: Double = inputNum1.text.toString().toDouble()
        val n2: Double = inputNum2.text.toString().toDouble()

        if (n2 == 0.0) {
            return
        } else {
            val res: Double = n1 / n2
            resultado.text = "O resultado é igual a: $res"
            resultado.visibility = View.VISIBLE
        }
    }
}