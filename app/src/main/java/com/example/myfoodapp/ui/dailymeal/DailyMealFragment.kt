package com.example.myfoodapp.ui.dailymeal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myfoodapp.R
import com.example.myfoodapp.adapters.DailyMealAdapter
import com.example.myfoodapp.databinding.DailyMealFragmentBinding
import com.example.myfoodapp.models.DailyMealModel

class DailyMealFragment : Fragment() {

    private var _binding: DailyMealFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var dailyMealAdapter: DailyMealAdapter
    private lateinit var recyclerView: RecyclerView
    private val dailyMealModels = ArrayList<DailyMealModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DailyMealFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        recyclerView = binding.dailyMealRec
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Add data
        dailyMealModels.add(DailyMealModel(R.drawable.breakfast, "Breakfast", "30% OFF", "breakfast", "Delicious and energizing meals to kickstart your day"))
        dailyMealModels.add(DailyMealModel(R.drawable.lunch, "Lunch", "20% OFF", "lunch", "Fresh and hearty dishes to keep you going"))
        dailyMealModels.add(DailyMealModel(R.drawable.dinner, "Dinner", "50% OFF", "dinner", "Flavorful meals to end your day perfectly"))
        dailyMealModels.add(DailyMealModel(R.drawable.desert, "Desert", "40% OFF", "desert", "Sweet treats to satisfy every craving"))
        dailyMealModels.add(DailyMealModel(R.drawable.coffee, "Coffee", "20% OFF", "coffee", "Rich, fresh, and perfect for any time"))

        // Setup adapter
        dailyMealAdapter = DailyMealAdapter(requireContext(), dailyMealModels)
        recyclerView.adapter = dailyMealAdapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}