package com.example.feastlyfling

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge // This import is used for edge-to-edge display
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat // This import is used for edge-to-edge display
import androidx.core.view.WindowInsetsCompat // This import is used for edge-to-edge display
import com.example.feastlyfling.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {

    // Using view binding for safer and easier access to views
    private val binding: ActivityStartBinding by lazy {
        ActivityStartBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.foodName)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.nextbutton.setOnClickListener {
            // Create an Intent to navigate from StartActivity to LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}