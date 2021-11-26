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

        when (diceRoll) {
            nrFaces -> Toast.makeText(this, "YOU GOT THE LUCKY NUMBER!", Toast.LENGTH_SHORT).show()
            1 -> Toast.makeText(this, "So sorry! You rolled a 1. Try again!", Toast.LENGTH_SHORT)
                .show()
            2 -> Toast.makeText(this, "Sadly, you rolled a 2. Try again!", Toast.LENGTH_SHORT)
                .show()
            3 -> Toast.makeText(
                this,
                "Unfortunately, you rolled a 3. Try again!",
                Toast.LENGTH_SHORT
            ).show()
            4 -> Toast.makeText(this, "Don't cry! You rolled a 4. Try again!", Toast.LENGTH_SHORT)
                .show()
            5 -> Toast.makeText(this, "Apologies! You rolled a 5. Try again!", Toast.LENGTH_SHORT)
                .show()
            else -> Toast.makeText(
                this,
                "Crap! You rolled a ${diceRoll}. Try again!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}