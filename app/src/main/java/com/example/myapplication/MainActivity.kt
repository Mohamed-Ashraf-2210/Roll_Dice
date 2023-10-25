package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: MaterialButton = findViewById(R.id.button)
        rollButton.setOnClickListener{ rootDices() }
    }

    // Roll the dice and update the screen with the result.
    private fun rootDices() {
        val imgDics: ImageView = findViewById(R.id.imageView)
        val num = randNum(6).toString()
        val numOne = findViewById<EditText>(R.id.numOne).text.toString()
        val numTwo = findViewById<EditText>(R.id.numTwo).text.toString()

        when (num) {
            "2" -> imgDics.setImageResource(R.drawable.dice_2)
            "3" -> imgDics.setImageResource(R.drawable.dice_3)
            "4" -> imgDics.setImageResource(R.drawable.dice_4)
            "5" -> imgDics.setImageResource(R.drawable.dice_5)
            "6" -> imgDics.setImageResource(R.drawable.dice_6)
            else -> imgDics.setImageResource(R.drawable.dice_1)
        }
        var msg = "Both is loser :)"
        if(num == numOne && num == numTwo) {
            msg = "Both is Win"
        } else if (num == numOne) {
            msg = "Player One is Winner"
        } else if (num == numTwo) {
            msg = "Player Two is Winner"
        }
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    // return a random number from range
    private fun randNum (numberOfDices: Int): Int {
        return (1..numberOfDices).random()
    }

}