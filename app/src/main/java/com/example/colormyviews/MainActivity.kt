package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)
        setListeners()

    }
//
    private fun setListeners() {
        val clickableViews: List<View> =
            listOf(binding.boxOneText,binding.boxTwoText,binding.boxThreeText,
                binding.boxFourText,binding.boxFiveText, binding.constraintLayout,
            binding.yellowButton, binding.greenButton,binding.redButton
            )

            for (item in clickableViews){
                item.setOnClickListener{makeColored(it)}
            }
    }

    private fun makeColored(view: View) {

        when (view.id) {

            // Boxes using Color class colors for background
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_blue_dark)



            R.id.red_button -> binding.boxFiveText.setBackgroundResource(R.color.my_red)
            R.id.green_button -> binding.boxFourText.setBackgroundResource(R.color.my_green)
            R.id.yellow_button -> binding.boxThreeText.setBackgroundResource(R.color.my_yellow)



            else -> view.setBackgroundColor(Color.LTGRAY)
        }

    }
}