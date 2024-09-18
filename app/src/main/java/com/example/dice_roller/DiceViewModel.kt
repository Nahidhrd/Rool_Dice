package com.example.dice_roller

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class DiceViewModel: ViewModel() {

    private val dices = listOf(
        R.drawable.empty_dice,
        R.drawable.dice_1,
        R.drawable.dice_2,
        R.drawable.dice_3,
        R.drawable.dice_4,
        R.drawable.dice_5,
        R.drawable.dice_6
    )

        private val numberOfDiceSides = 6

        private val _pickedDice = MutableLiveData<Int>()
        val pickedDice : LiveData<Int>
        get() = _pickedDice

        private val _score = MutableLiveData<Int>()
        val score : LiveData<Int>
            get() = _score

        init {
            _score.value = 0
        }

        fun diceRoll(){

        val dice = Dice(numberOfDiceSides)
            val numbs = dice.roll()
            _pickedDice.postValue(dices[numbs])

            _score.value = +(numbs)

    }

    fun clear (){
        _score.value = 0
    }
}