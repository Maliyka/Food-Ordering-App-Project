package com.example.feastlyfling

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView // Import AutoCompleteTextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.feastlyfling.databinding.ActivityLocationBinding

class LocationActivity : AppCompatActivity() {
    private val binding: ActivityLocationBinding by lazy {
        ActivityLocationBinding.inflate(layoutInflater)
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
        val locationList: Array<String> = arrayOf("Johar Town", "Wapda Town", "Gulberg", "Lake City")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, locationList)

         val autoCompleteTextView: AutoCompleteTextView = binding.ListOfLocation as AutoCompleteTextView

        autoCompleteTextView.setAdapter(adapter)
    }
}