package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var diceImage:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener{
            rollDice() // Calling the roll dice function responsible for image change in the app UI
            //Just changes the text of button on each click
            if (rollButton.text == "Lets Roll")
                rollButton.text = R.string.roll.toString()
                else
                    rollButton.text = R.string.alt_roll.toString()
            //function to actually change the number displayed in the TextView

            Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun rollDice() {
        val randomInt : Int = Random.nextInt(6)+1
        val resultText: TextView = findViewById(R.id.result_text)
        Log.d("Numeric Value",randomInt.toString())
        diceImage = findViewById(R.id.dice_image)

        val drawableResource = when (randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
        resultText.text = randomInt.toString()
    }
}