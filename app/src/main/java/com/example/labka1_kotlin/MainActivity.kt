package com.example.labka1_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextNumber = findViewById<EditText>(R.id.editTextNumber)
        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)

        buttonCalculate.setOnClickListener {
            val input = editTextNumber.text.toString()

            if (input.isNotEmpty()) {
                try {
                    val A = input.toInt()
                    val result = calculateX(A)
                    if (result != null) {
                        Toast.makeText(this, "The smallest natural number x is $result", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "No such natural number x exists", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun calculateX(A: Int): Int? {
        var x = 1
        while (true) {
            val expressionResult = A * x * x + 1
            val sqrtResult = sqrt(expressionResult.toDouble()).toInt()
            if (sqrtResult * sqrtResult == expressionResult) {
                return x
            }
            x++
        }
    }
}
