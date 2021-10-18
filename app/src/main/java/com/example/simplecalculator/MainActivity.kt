package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var ed1: EditText
    private lateinit var ed2: EditText

    private lateinit var btnPlus: Button
    private lateinit var btnMin: Button
    private lateinit var btnMulti: Button
    private lateinit var btnDiv: Button

    private lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ed1 = findViewById(R.id.ed1)
        ed2 = findViewById(R.id.ed2)

        btnPlus = findViewById(R.id.btnplus)
        btnMin = findViewById(R.id.btnMin)
        btnMulti = findViewById(R.id.btnMulti)
        btnDiv = findViewById(R.id.btnDiv)

        tv = findViewById(R.id.tv)

        btnPlus.setOnClickListener {
            calculate("+")
            ed1.text.clear()
            ed2.text.clear()
        }
        btnMin.setOnClickListener {
            calculate("-")
            ed1.text.clear()
            ed2.text.clear()
        }
        btnMulti.setOnClickListener {
            calculate("*")
            ed1.text.clear()
            ed2.text.clear()
        }
        btnDiv.setOnClickListener {
            calculate("/")
            ed1.text.clear()
            ed2.text.clear()
        }

    }

    fun calculate(op: String) {
        var result = 0f
        var num1 = ed1.text.toString().toFloat()
        var num2 = ed2.text.toString().toFloat()

        when (op) {
            "+" -> {result = num1 + num2}
            "-" -> {result = num1 - num2}
            "*" -> {result = num1 * num2}
            "/" -> {
                if (num2 == 0f) {
                    Toast.makeText(applicationContext, "Cant div to zero", Toast.LENGTH_LONG).show()
                } else {
                    result = num1 / num2
                }
            }
        }
        tv.text = result.toString()
    }
}