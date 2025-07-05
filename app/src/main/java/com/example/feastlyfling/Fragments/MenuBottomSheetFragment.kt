package com.example.feastlyfling.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.feastlyfling.R
import com.example.feastlyfling.adapter.MenuAdapter
import com.example.feastlyfling.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MenuBottomSheetFragment :BottomSheetDialogFragment() {
private lateinit var binding:FragmentMenuBottomSheetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMenuBottomSheetBinding.inflate(inflater,container,false)
        binding.backbutton.setOnClickListener{
            dismiss()
        }
        val menuFoodName= listOf("Burger", "Sandwich","Biryani","Beverages", "Salad","Burger", "Sandwich","Biryani","Beverages", "Salad")
        val menuItemPrice = listOf("$4", "$9","$2","$8","$12","$4", "$9","$2","$8","$12")
        val menuImage= listOf(
            R.drawable.menuphoto1,
            R.drawable.menuphoto2,
            R.drawable.menuphoto3,
            R.drawable.menuphoto4,
            R.drawable.menuphoto5,
            R.drawable.menuphoto1,
            R.drawable.menuphoto2,
            R.drawable.menuphoto3,
            R.drawable.menuphoto4,
            R.drawable.menuphoto5,
        )
        val adapter = MenuAdapter(ArrayList(menuFoodName),ArrayList(menuItemPrice),ArrayList(menuImage),requireContext())
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter

        return binding.root
    }


    companion object {

    }
}