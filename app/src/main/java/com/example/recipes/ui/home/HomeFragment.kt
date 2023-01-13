package com.example.recipes.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recipes.R
import com.example.recipes.databinding.FragmentHomeBinding
import com.example.recipes.helper.gone
import com.example.recipes.helper.visible
import com.wahyu.recipes.core.data.Async
import com.wahyu.recipes.core.model.Recipes
import com.wahyu.recipes.core.ui.RecipeListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<HomeViewModel>()

    companion object {
        private const val TAG = "HomeFragment"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configDrawer()

        val mAdapter = RecipeListAdapter()
        val grid = GridLayoutManager(requireActivity(), 2)

        binding.rvListRecipe.apply {
            adapter = mAdapter
            layoutManager = grid
        }

        mAdapter.setClickListener(object : RecipeListAdapter.OnItemClickListener {
            override fun onDetailClick(recipes: Recipes) {
                val go =
                    HomeFragmentDirections.actionHomeFragmentToRecipeInformationFragment(recipes.id)
                findNavController().navigate(go)
            }
        })

        lifecycleScope.launch {

            viewModel.useCase.getRecipes().collect {
                when (it) {
                    is Async.Error -> {
                        binding.progressBar.gone()
                        mAdapter.submitList(it.data)
                        Log.w(TAG, "onViewCreated: offline data : ${it.data}")
                    }
                    is Async.Loading -> {
                        binding.progressBar.visible()
                    }
                    is Async.Success -> {
                        binding.progressBar.gone()
                        mAdapter.submitList(it.data)
                    }
                }
            }
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