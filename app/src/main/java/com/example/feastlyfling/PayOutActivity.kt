package com.example.feastlyfling

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.feastlyfling.databinding.ActivityPayoutBinding

class PayOutActivity : AppCompatActivity() {
    lateinit var binding : ActivityPayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.placemyorderbutton.setOnClickListener {
            val  bottomSheetDialog = congratsBottomFragment()
            bottomSheetDialog.show(supportFragmentManager,"test")

        }
    }
}