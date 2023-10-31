package com.example.myapplication

class Dice(private val numberOfSides: Int) {
        fun roll() = (1..numberOfSides).random().toString()
}