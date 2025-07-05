package com.example.feastlyfling.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.feastlyfling.databinding.CartItemBinding

class cartAdapter (private  val cartItem:MutableList<String>, private val CartItemPrice :MutableList<String>, private  var CartImage:MutableList<Int>): RecyclerView.Adapter<cartAdapter.CartViewHolder>() {
 private val itemQuantities  =IntArray(cartItem.size){1}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding =CartItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CartViewHolder(binding)
    }
    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }
    override fun getItemCount(): Int = cartItem.size
    inner class CartViewHolder (private val binding: CartItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int) {
            binding.apply {
                    val quantity =itemQuantities[position]
                cartFoodName.text=cartItem[position]
                cartItemPrice.text= CartItemPrice[position]
                cartImage.setImageResource(CartImage[position])
                cartaItemQuantity.text= quantity.toString()

                minusbutton.setOnClickListener{
                    decreaseQunatity(position)
                }
                plusbutton.setOnClickListener{
                    increaseQunatity(position)
                }
                deletebutton.setOnClickListener{
                    val itemPosition =adapterPosition
                        if (itemPosition!= RecyclerView.NO_POSITION){
                            deleteItem(itemPosition)
                        }
                    }
            }
        }


        fun decreaseQunatity(position:Int){
            if(itemQuantities[position]>1){
                itemQuantities[position]--
                binding.cartaItemQuantity.text =itemQuantities[position].toString()
            }
        }

        fun increaseQunatity(position:Int){
            if(itemQuantities[position]<10){
                itemQuantities[position]++
                binding.cartaItemQuantity.text =itemQuantities[position].toString()
            }
        }

        fun deleteItem(position: Int){
            cartItem.removeAt(position)
            CartItemPrice.removeAt(position)
            CartImage.removeAt(position)
            notifyItemRemoved(position)
            notifyItemChanged(position, cartItem.size)
        }

    }
}