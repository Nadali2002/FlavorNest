package com.example.myfoodapp.ui

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myfoodapp.R
import com.example.myfoodapp.adapters.CartAdapter
import com.example.myfoodapp.models.CartModel

class MyCartFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var cartAdapter: CartAdapter
    private val list = mutableListOf<CartModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_my_cart, container, false)

        recyclerView = view.findViewById(R.id.cart_rec)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Avoid duplicates if fragment is re-created
        if (list.isEmpty()) {
            list.add(CartModel(R.drawable.fries1, "Order 1", "Rs.1100.00", "4.7"))
            list.add(CartModel(R.drawable.burger1, "Order 2", "Rs.1200.00", "4.8"))
            list.add(CartModel(R.drawable.pizza2, "Order 3", "Rs.3500.00", "4.9"))
            list.add(CartModel(R.drawable.sandwich3, "Order 4", "Rs.900.00", "4.5"))
            list.add(CartModel(R.drawable.ice_cream2, "Order 5", "Rs.650.00", "4.9"))
            list.add(CartModel(R.drawable.sandwich4, "Order 6", "Rs.1100.00", "4.8"))
        }

        cartAdapter = CartAdapter(list)
        recyclerView.adapter = cartAdapter

        //Show AlertDialog on button click
        val makeOrderButton: Button = view.findViewById(R.id.button)
        makeOrderButton.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Order Successful")
                .setMessage("Your order has been placed successfully!")
                .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                .show()
        }

        return view
    }
}
