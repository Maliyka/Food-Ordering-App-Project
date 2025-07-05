package com.example.feastlyfling.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.feastlyfling.R
import com.example.feastlyfling.adapter.NotificationAdapter
import com.example.feastlyfling.databinding.FragmentNotificationBottomBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.ArrayList


class Notification_Bottom_Fragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentNotificationBottomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationBottomBinding.inflate(layoutInflater,container,false)
        val notification = listOf("Your order has been Canceled Successfully", "Order has been taken by the driver","Congrats Your Order Placed")
        val notificationImages= listOf(R.drawable.cancel, R.drawable.truck, R.drawable.sucess)
        val adapter = NotificationAdapter( ArrayList(notification),ArrayList(notificationImages))
binding.notificationRecyclerView.layoutManager =LinearLayoutManager(requireContext())
        binding.notificationRecyclerView.adapter =adapter
        return binding.root
    }

    companion object {

    }
}