package com.example.feastlyfling.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.feastlyfling.DetailsActivity
import com.example.feastlyfling.databinding.MenuItemBinding


class MenuAdapter(
    private val menuItemName: List<String>,
    private val menuItemPrice: List<String>, // Corrected capitalization for convention
    private val menuImage: List<Int>,         // Corrected capitalization for convention
    private val requireContext: Context,
    // Add the OnClickListner as a parameter in the constructor
    private val itemClickListener: OnClickListner? = null // Make it nullable and optional
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    // Removed the problematic initialization here.
    // The itemClickListener is now directly a constructor parameter.

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = menuItemName.size

    inner class MenuViewHolder(private val binding: MenuItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            // Set the click listener here
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    // Call the listener if it's not null
                    itemClickListener?.onItemClick(position) // Corrected method name to onItemClick

                    // Create and start the intent ONLY when the item is clicked
                    val intent = Intent(requireContext, DetailsActivity::class.java).apply {
                        putExtra("MenuItemName", menuItemName[position])
                        putExtra("MenuItemPrice", menuItemPrice[position]) // Added price to intent
                        putExtra("MenuItemImage", menuImage[position])
                    }
                    requireContext.startActivity(intent)
                }
            }
        }

        fun bind(position: Int) {
            binding.apply {
                foodnamemenu.text = menuItemName[position]
                pricemenu.text = menuItemPrice[position] // Use corrected variable name
                imagemenu.setImageResource(menuImage[position]) // Use corrected variable name
            }
        }
    }
}

// Corrected interface method name to match usage
interface OnClickListner{
    fun onItemClick(position: Int) // Changed from onItemclick to onItemClick
}