package com.example.myfoodapp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myfoodapp.R
import com.example.myfoodapp.models.DailyMealModel

class DailyMealAdapter(
    private val context: Context,
    private val mealList: List<DailyMealModel>
) : RecyclerView.Adapter<DailyMealAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.daily_meal_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val meal = mealList[position]
        holder.imageView.setImageResource(meal.image)
        holder.name.text = meal.name
        holder.discount.text = meal.discount
        holder.description.text = meal.description


    }

    override fun getItemCount(): Int = mealList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val name: TextView = itemView.findViewById(R.id.textView9)
        val description: TextView = itemView.findViewById(R.id.textView10)
        val discount: TextView = itemView.findViewById(R.id.discount)
    }
}