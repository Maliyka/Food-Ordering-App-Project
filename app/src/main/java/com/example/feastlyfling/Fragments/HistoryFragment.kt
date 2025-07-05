package com.example.feastlyfling.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.feastlyfling.R
import com.example.feastlyfling.adapter.BuyAgainAdapter
import com.example.feastlyfling.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding
    private lateinit var buyAgainAdapter: BuyAgainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentHistoryBinding.inflate(layoutInflater,container,false)
        setupRecyclerView()
        return binding.root
    }
    private fun setupRecyclerView(){
        val buyAgainFoodName= arrayListOf("Burger", "Sandwich","Biryani","Beverages", "Salad","Burger", "Sandwich","Biryani","Beverages", "Salad")
        val buyAgainFoodPrice = arrayListOf("$4", "$9","$2","$8","$12","$4", "$9","$2","$8","$12")
        val buyAgainFoodImage= arrayListOf(
            R.drawable.menuphoto1,
            R.drawable.menuphoto2,
            R.drawable.menuphoto3,
            R.drawable.menuphoto4,
            R.drawable.menuphoto5,
            R.drawable.menuphoto1,
            R.drawable.menuphoto2,
            R.drawable.menuphoto3,
            R.drawable.menuphoto4,
            R.drawable.menuphoto5
        )
        buyAgainAdapter = BuyAgainAdapter(buyAgainFoodName, buyAgainFoodPrice,buyAgainFoodImage)
        binding.buyAgainRecyclerView.adapter=buyAgainAdapter

        binding.buyAgainRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    }
    companion object {
    }
}