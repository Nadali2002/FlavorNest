package com.example.myfoodapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myfoodapp.R
import com.example.myfoodapp.models.HomeVerModel
import com.google.android.material.bottomsheet.BottomSheetDialog

class HomeVerAdapter(
    private val context: Context,
    private var list: List<HomeVerModel>
) : RecyclerView.Adapter<HomeVerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.home_vertical_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        holder.imageView.setImageResource(item.image)
        holder.name.text = item.name
        holder.timing.text = item.timing
        holder.rating.text = item.rating
        holder.price.text = item.price

        holder.itemView.setOnClickListener {
            // Create BottomSheetDialog
            val bottomSheetDialog = BottomSheetDialog(context, R.style.BottomSheetTheme)
            val sheetView = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_layout, null)

            // Bottom sheet views
            val bottomImg: ImageView = sheetView.findViewById(R.id.sheet_img)
            val bottomName: TextView = sheetView.findViewById(R.id.sheet_name)
            val bottomTiming: TextView = sheetView.findViewById(R.id.sheet_timing)
            val bottomRating: TextView = sheetView.findViewById(R.id.sheet_rating)
            val bottomPrice: TextView = sheetView.findViewById(R.id.sheet_price)
            val addToCart: TextView = sheetView.findViewById(R.id.add_to_cart)

            // Set data
            bottomImg.setImageResource(item.image)
            bottomName.text = item.name
            bottomTiming.text = item.timing
            bottomRating.text = item.rating
            bottomPrice.text = item.price

            // Add to cart click
            addToCart.setOnClickListener {
                Toast.makeText(context, "Added to Cart", Toast.LENGTH_SHORT).show()
                bottomSheetDialog.dismiss()
            }

            // Show BottomSheetDialog
            bottomSheetDialog.setContentView(sheetView)
            bottomSheetDialog.show()
        }
    }

    override fun getItemCount(): Int = list.size

    fun updateList(newList: List<HomeVerModel>) {
        list = newList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.ver_img)
        val name: TextView = itemView.findViewById(R.id.name)
        val timing: TextView = itemView.findViewById(R.id.timing)
        val rating: TextView = itemView.findViewById(R.id.rating)
        val price: TextView = itemView.findViewById(R.id.price)
    }
}
