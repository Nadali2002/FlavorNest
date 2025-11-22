package com.example.myfoodapp.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.myfoodapp.R
import com.example.myfoodapp.models.HomeHorModel
import com.example.myfoodapp.models.HomeVerModel

class HomeHorAdapter(
    private val updateVerticalRec: UpdateVerticalRec,
    private val activity: Activity,
    private val list: MutableList<HomeHorModel>   // <-- use MutableList
) : RecyclerView.Adapter<HomeHorAdapter.ViewHolder>() {

    private var check = true
    private var select = true
    private var rowIndex = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(activity)
            .inflate(R.layout.home_horizontal_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.imageView.setImageResource(item.image)
        holder.name.text = item.name

        // Default first load for vertical list
        if (check) {
            val defaultVerticalList = mutableListOf(
                HomeVerModel(R.drawable.pizza1, "Pepperoni", "10:00 - 23:00", "4.8", "Rs.3800.00"),
                HomeVerModel(R.drawable.pizza2, "Margherita", "10:00 - 23:00", "4.9", "Rs.3900.00"),
                HomeVerModel(R.drawable.pizza3, "Hawaiian", "10:00 - 23:00", "4.9", "Rs.4000.00"),
                HomeVerModel(R.drawable.pizza4, "Cheese Pizza", "10:00 - 23:00", "4.9", "Rs.4500.00")
            )
            updateVerticalRec.callBack(position, defaultVerticalList)
            check = false
        }

        // Change background for selection
        if (select) {
            if (position == 0) {
                holder.cardView.setBackgroundResource(R.drawable.change_bg)
                select = false
            }
        } else {
            holder.cardView.setBackgroundResource(
                if (rowIndex == position) R.drawable.change_bg else R.drawable.default_bg
            )
        }

        // Handle item click to update vertical list
        holder.cardView.setOnClickListener {
            val adapterPos = holder.adapterPosition
            if (adapterPos == RecyclerView.NO_POSITION) return@setOnClickListener

            rowIndex = adapterPos
            notifyDataSetChanged()

            val verticalList = when (adapterPos) {
                0 -> mutableListOf(
                    HomeVerModel(R.drawable.pizza1, "Pepperoni", "10:00 - 23:00", "4.8", "Rs.3800.00"),
                    HomeVerModel(R.drawable.pizza2, "Margherita", "10:00 - 23:00", "4.9", "Rs.3900.00"),
                    HomeVerModel(R.drawable.pizza3, "Hawaiian", "10:00 - 23:00", "4.9", "Rs.4000.00"),
                    HomeVerModel(R.drawable.pizza4, "Cheese Pizza", "10:00 - 23:00", "4.9", "Rs.4500.00")
                )
                1 -> mutableListOf(
                    HomeVerModel(R.drawable.burger1, "CheeseBurger", "10:00 - 23:00", "4.8", "Rs.1200.00"),
                    HomeVerModel(R.drawable.burger2, "BaconBurger", "10:00 - 23:00", "4.9", "Rs.1500.00"),
                    HomeVerModel(R.drawable.burger3, "RamlyBurger", "10:00 - 23:00", "4.9", "Rs.1480.00"),
                    HomeVerModel(R.drawable.burger4, "AussieBurger", "10:00 - 23:00", "4.9", "Rs.1500.00")
                )
                2 -> mutableListOf(
                    HomeVerModel(R.drawable.fries1, "WaffleFries", "10:00 - 23:00", "4.9", "Rs.1100.00"),
                    HomeVerModel(R.drawable.fries2, "GarlicFries", "10:00 - 23:00", "4.9", "Rs.1200.00"),
                    HomeVerModel(R.drawable.fries3, "SweetPotatoFries", "10:00 - 23:00", "4.9", "Rs.1200.00"),
                    HomeVerModel(R.drawable.fries4, "Chilly Cheese Fries", "10:00 - 23:00", "4.9", "Rs.1250.00")
                )
                3 -> mutableListOf(
                    HomeVerModel(R.drawable.ice_cream1, "Strawberry", "10:00 - 23:00", "4.9", "Rs.650.00"),
                    HomeVerModel(R.drawable.ice_cream2, "Coffee", "10:00 - 23:00", "4.9", "Rs.700.00"),
                    HomeVerModel(R.drawable.ice_cream3, "Caramel", "10:00 - 23:00", "4.9", "Rs.700.00"),
                    HomeVerModel(R.drawable.ice_cream4, "Vanilla", "10:00 - 23:00", "4.9", "Rs.600.00"),
                    HomeVerModel(R.drawable.ice_cream5, "Chocolate", "10:00 - 23:00", "4.9", "Rs.600.00"),
                    HomeVerModel(R.drawable.ice_cream6, "RedBean", "10:00 - 23:00", "4.9", "Rs.700.00")
                )
                4 -> mutableListOf(
                    HomeVerModel(R.drawable.sandwich1, "ChickenClub", "10:00 - 23:00", "4.8", "Rs.1100.00"),
                    HomeVerModel(R.drawable.sandwich2, "Cuban", "10:00 - 23:00", "4.9", "Rs.1000.00"),
                    HomeVerModel(R.drawable.sandwich3, "Grilled Cheese", "10:00 - 23:00", "4.9", "Rs.900.00"),
                    HomeVerModel(R.drawable.sandwich4, "Egg Salad", "10:00 - 23:00", "4.9", "Rs.900.00")
                )
                5 -> mutableListOf(
                    HomeVerModel(R.drawable.c1, "Ice Coffee", "10:00 - 23:00", "4.8", "Rs.1100.00"),
                    HomeVerModel(R.drawable.c2, "Cappuccino", "10:00 - 23:00", "4.9", "Rs.850.00"),
                    HomeVerModel(R.drawable.c3, "Espresso", "10:00 - 23:00", "4.9", "Rs.750.00"),
                    HomeVerModel(R.drawable.c4, "Black Coffee", "10:00 - 23:00", "4.9", "Rs.750.00")
                )
                6 -> mutableListOf(
                    HomeVerModel(R.drawable.de1, "Lemon Cake", "10:00 - 23:00", "4.8", "Rs.900.00"),
                    HomeVerModel(R.drawable.de2, "Swiss Roll", "10:00 - 23:00", "4.9", "Rs.700.00"),
                    HomeVerModel(R.drawable.de3, "Tiramisu Cake", "10:00 - 23:00", "4.9", "Rs.1100.00"),
                    HomeVerModel(R.drawable.de4, "Rasgulla", "10:00 - 23:00", "4.9", "Rs.600.00")
                )


                else -> mutableListOf()
            }

            updateVerticalRec.callBack(adapterPos, verticalList)
        }
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.hor_img)
        val name: TextView = itemView.findViewById(R.id.hor_text)
        val cardView: CardView = itemView.findViewById(R.id.cardView)
    }
}
