package com.example.feastlyfling

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.feastlyfling.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding :ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding=ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val foodName = intent.getStringExtra("MenuItemName")
        val foodImage = intent.getIntExtra("MenuItemImage", 0)
        binding.detailedFoodName.text = foodName
        binding.detailedFoodImage.setImageResource(foodImage)
        binding.backButton.setOnClickListener{
            finish()
        }
    }
}