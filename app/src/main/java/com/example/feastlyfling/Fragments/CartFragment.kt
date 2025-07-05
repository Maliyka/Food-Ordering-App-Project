package com.example.feastlyfling.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.feastlyfling.PayOutActivity
import com.example.feastlyfling.R
import com.example.feastlyfling.adapter.cartAdapter
import com.example.feastlyfling.congratsBottomFragment
import com.example.feastlyfling.databinding.FragmentCartBinding
import com.example.feastlyfling.databinding.FragmentCongratsBottomBinding


class CartFragment : Fragment() {
private lateinit var binding:FragmentCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater,container,false)
        val cartFoodName= listOf("Burger", "Sandwich","Biryani","Beverages", "Salad")
        val cartItemPrice = listOf("$4", "$9","$2","$8","$12")
        val cartImage= listOf(
            R.drawable.menuphoto1,
            R.drawable.menuphoto2,
            R.drawable.menuphoto3,
            R.drawable.menuphoto4,
            R.drawable.menuphoto5,
        )
        val adapter = cartAdapter(ArrayList(cartFoodName),ArrayList(cartItemPrice),ArrayList(cartImage))
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter = adapter
binding.proceedButton.setOnClickListener {
    val intent= Intent(requireContext(),PayOutActivity::class.java)
    startActivity(intent)
}
         return binding.root
    }

    companion object {
    }
}