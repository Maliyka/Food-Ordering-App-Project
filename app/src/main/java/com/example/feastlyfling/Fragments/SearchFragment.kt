package com.example.feastlyfling.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.feastlyfling.R
import com.example.feastlyfling.adapter.MenuAdapter
import com.example.feastlyfling.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: MenuAdapter
    private  val orignalMenuFoodName:List<String> = listOf("Burger", "Sandwich","Biryani","Beverages", "Salad")
    private val orignalMenuItemPrice = listOf("$4", "$9","$2","$8","$12")
    private val orignalImage= listOf(
        R.drawable.menuphoto1,
        R.drawable.menuphoto2,
        R.drawable.menuphoto3,
        R.drawable.menuphoto4,
        R.drawable.menuphoto5,
    )

    private val filterMenuFoodName = mutableListOf<String>()
    private val filterMenuFoodPrice = mutableListOf<String>()
    private val filterMenuFoodImage = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container,false)
        adapter= MenuAdapter(filterMenuFoodName, filterMenuFoodPrice, filterMenuFoodImage, requireContext())
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter

        //setup for search view
        setupSearchView()
        // show all menus item
        showAllMenu()
        return binding.root
    }
@SuppressLint("notifyDataSetChanged")
    private fun showAllMenu() {
        filterMenuFoodName.clear()
        filterMenuFoodPrice.clear()
        filterMenuFoodImage.clear()

        filterMenuFoodName.addAll(orignalMenuFoodName)
        filterMenuFoodPrice.addAll(orignalMenuItemPrice)
        filterMenuFoodImage.addAll(orignalImage)

        adapter.notifyDataSetChanged()


    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItem(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItem(newText)
                return true
            }

        })
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun filterMenuItem(query: String?) {
        filterMenuFoodName.clear()
        filterMenuFoodPrice.clear()
        filterMenuFoodImage.clear()

        orignalMenuFoodName.forEachIndexed{ index, foodName ->
            if (foodName.contains(query.toString(), ignoreCase = true)){
                filterMenuFoodName.add(foodName)
                filterMenuFoodPrice.add(orignalMenuItemPrice[index])
                filterMenuFoodImage.add(orignalImage[index])
            }
        }
        adapter.notifyDataSetChanged()
    }

    companion object {

    }
}