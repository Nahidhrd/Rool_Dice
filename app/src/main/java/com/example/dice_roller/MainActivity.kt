package com.example.dice_roller

import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

import com.example.dice_roller.databinding.ActivityMainBinding


class MainActivity() : AppCompatActivity() {
    private val ROLL_DURATION = 4000L
    private val ROLL_INTERVAL = 300L

     var score1 : Int = 0

    private lateinit var binding: ActivityMainBinding

    //1-  viewModel object create
    private val viewModel by viewModels <DiceViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.rollButton1.setOnClickListener {
            diceRoll()
        }

        viewModel.score.observe(this){ score ->

            binding.resultView.text = "Score : $score"

        }

        //2-  viewModel Observer fun() Create ->
        diceNumberObserver()
        closeDice()
    }

    private fun closeDice() {
        
        binding.buttonclose.setOnClickListener {
            viewModel.clear()

        }
    }

    private fun diceRoll() {
        val countDownTimer = object : CountDownTimer(ROLL_DURATION, ROLL_INTERVAL) {
            override fun onTick(p0: Long) {
                selectedDice()
                binding.rollButton1.isEnabled = true
            }

            override fun onFinish() {
                selectedDice()
                binding.rollButton1.isEnabled= false

            }
        }
        countDownTimer.start()
    }

    // 3->  Fun() <-
    private fun diceNumberObserver() {
        viewModel.pickedDice.observe(this) { dice ->
            binding.imageView.setImageResource(dice)
        }
    }
       fun selectedDice() {
        viewModel.diceRoll()

        }

      }



