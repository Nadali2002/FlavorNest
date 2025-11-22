package com.example.myfoodapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myfoodapp.R
import com.example.myfoodapp.adapters.HomeHorAdapter
import com.example.myfoodapp.adapters.HomeVerAdapter
import com.example.myfoodapp.adapters.UpdateVerticalRec
import com.example.myfoodapp.models.HomeHorModel
import com.example.myfoodapp.models.HomeVerModel
import com.example.myfoodapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), UpdateVerticalRec {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var homeHorizontalRec: RecyclerView
    private lateinit var homeVerticalRec: RecyclerView

    private lateinit var homeHorAdapter: HomeHorAdapter
    private lateinit var homeVerAdapter: HomeVerAdapter

    private var homeHorModelList = mutableListOf<HomeHorModel>()
    private var homeVerModelList = mutableListOf<HomeVerModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        homeHorizontalRec = root.findViewById(R.id.home_hor_rec)
        homeVerticalRec = root.findViewById(R.id.home_ver_rec)

        setupHorizontalRecycler()
        setupVerticalRecycler()

        return root
    }

    private fun setupHorizontalRecycler() {
        // Use MutableList, no need for ArrayList specifically
        homeHorModelList = mutableListOf(
            HomeHorModel(R.drawable.pizza, "Pizza"),
            HomeHorModel(R.drawable.burger, "Burger"),
            HomeHorModel(R.drawable.fries, "Fries"),
            HomeHorModel(R.drawable.ice_cream, "Ice Cream"),
            HomeHorModel(R.drawable.sandwich, "Sandwich"),
            HomeHorModel(R.drawable.c2, "Coffee"),
            HomeHorModel(R.drawable.de3, "Dessert")
        )

        // Pass 'this' as UpdateVerticalRec and activity
        homeHorAdapter = HomeHorAdapter(this, requireActivity(), homeHorModelList)
        homeHorizontalRec.adapter = homeHorAdapter
        homeHorizontalRec.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL, false)
        homeHorizontalRec.setHasFixedSize(true)
        homeHorizontalRec.isNestedScrollingEnabled = false
    }

    private fun setupVerticalRecycler() {
        homeVerModelList = mutableListOf() // start empty

        homeVerAdapter = HomeVerAdapter(requireActivity(), homeVerModelList)
        homeVerticalRec.adapter = homeVerAdapter
        homeVerticalRec.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        homeVerticalRec.setHasFixedSize(true)
        homeVerticalRec.isNestedScrollingEnabled = false
    }

    // Called when horizontal item clicked
    override fun callBack(position: Int, list: List<HomeVerModel>) {
        homeVerAdapter.updateList(list)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
