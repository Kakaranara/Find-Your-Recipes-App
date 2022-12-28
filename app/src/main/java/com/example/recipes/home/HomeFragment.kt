package com.example.recipes.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recipes.R
import com.example.recipes.databinding.FragmentHomeBinding
import com.example.recipes.helper.showToast
import com.wahyu.recipes.core.data.remote.retrofit.ApiConfig
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configDrawer()

        val mAdapter = RecipeListAdapter()
        val grid = GridLayoutManager(requireActivity(), 2)

        lifecycleScope.launch {
            ApiConfig.service().getRecipe(ApiConfig.token, 10, "breakfast")
        }

        binding.rvListRecipe.apply {
            adapter = mAdapter
            layoutManager = grid
        }
    }

    private fun configDrawer() {
        val navController = findNavController()
        val drawerLayout = requireActivity().findViewById<DrawerLayout>(R.id.drawerLayout)
        val appConfig = AppBarConfiguration(navController.graph, drawerLayout)

        binding.toolbar2.setupWithNavController(navController, appConfig)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}