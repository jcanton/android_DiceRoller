package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice() {

        val nrInput: EditText = findViewById(R.id.editTextNumberPassword)
        val nrFacesText = nrInput.text.toString()
        val nrFaces: Int = if (nrFacesText == "") 1 else Integer.parseInt(nrFacesText)

        val dice = Dice(nrFaces)
        val diceRoll = dice.roll()
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
        if (diceRoll == nrFaces) Toast.makeText(this, "You got a lucky number!", Toast.LENGTH_SHORT).show()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}