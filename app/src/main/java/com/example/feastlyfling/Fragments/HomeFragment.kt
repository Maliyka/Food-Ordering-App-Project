package com.example.feastlyfling.Fragments

import android.health.connect.datatypes.units.Length
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.feastlyfling.R
import com.example.feastlyfling.adapter.popularadapter
import com.example.feastlyfling.databinding.ActivityLocationBinding
import com.example.feastlyfling.databinding.FragmentHomeBinding
import org.jetbrains.annotations.TestOnly


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container,false)

        binding.viewallmenu.setOnClickListener{
            val bottomSheetDialog = MenuBottomSheetFragment()
            bottomSheetDialog.show(parentFragmentManager,"MenuBottomSheetTag")
        }
        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imagelist = ArrayList<SlideModel>()
        imagelist.add(SlideModel(R.drawable.banner1, ScaleTypes.FIT))
        imagelist.add(SlideModel(R.drawable.banner2, ScaleTypes.FIT))
        imagelist.add(SlideModel(R.drawable.banner3, ScaleTypes.FIT))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imagelist)
        imageSlider.setImageList(imagelist , ScaleTypes.FIT)
        imageSlider.setItemClickListener(object :ItemClickListener{
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int) {
                val itemPosition = imagelist[position]
                val itemMessage ="Selected Image $position"
                Toast.makeText(requireContext(),itemMessage,Toast.LENGTH_SHORT).show()
            }
        })
        val foodNames= listOf("Burger", "Sandwich", "Dumplings", "Salad", "Crabs")
        val prices = listOf("$5","$8","$3", "$9","$20")
        val foodImages = listOf(R.drawable.menuphoto1, R.drawable.menuphoto2,R.drawable.menuphoto3,R.drawable.menuphoto4, R.drawable.menuphoto5)
val adapter =popularadapter(foodNames,prices,foodImages,requireContext())
        binding.popularRecyclerView.layoutManager=LinearLayoutManager(requireContext())
        binding.popularRecyclerView.adapter =adapter

    }

    companion object {

    }
}