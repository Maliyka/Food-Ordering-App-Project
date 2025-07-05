package com.example.feastlyfling.adapter

import android.content.Context
import android.content.Intent
import android.icu.text.Transliterator.Position
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.feastlyfling.DetailsActivity
import com.example.feastlyfling.databinding.FragmentHomeBinding
import com.example.feastlyfling.databinding.PopularItemBinding

class popularadapter (private  val items:List<String>, private val price:List<String>, private val image:List<Int>, private val requireContext: Context) : RecyclerView.Adapter<popularadapter.popularviewholder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): popularviewholder {
        return popularviewholder(PopularItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }



    override fun onBindViewHolder(holder: popularviewholder, position: Int) {
        val item = items[position]
        val images = image[position]
        val price =price[position]
        holder.bind(item,images,price)
        holder.itemView.setOnClickListener{
            val intent = Intent(requireContext, DetailsActivity::class.java).apply {
                putExtra("MenuItemName", item)
                putExtra("MenuItemImage", images)
            }
            requireContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
    class popularviewholder (private val binding:  PopularItemBinding) :RecyclerView.ViewHolder(binding.root) {
       val imagesView=binding.imagepopular
        fun bind(item: String, images: Int, price: String) {
            binding.foodnamepopular.text = item
            binding.pricepopular.text = price
            imagesView.setImageResource(images)

        }

    }
}