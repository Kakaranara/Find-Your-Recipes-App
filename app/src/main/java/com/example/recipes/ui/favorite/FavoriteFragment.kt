package com.example.recipes.ui.favorite

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recipes.R
import com.example.recipes.databinding.FragmentFavoriteBinding
import com.example.recipes.ui.home.HomeFragmentDirections
import com.wahyu.recipes.core.model.Recipes
import com.wahyu.recipes.core.ui.RecipeListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavoriteFragment : Fragment() {
    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<FavoriteViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.favoriteToolbar.setupWithNavController(findNavController())

        val mAdapter = RecipeListAdapter()
        val grid = GridLayoutManager(requireActivity(), 2)

        binding.rvListRecipe.apply {
            adapter = mAdapter
            layoutManager = grid
        }

        mAdapter.setClickListener(object : RecipeListAdapter.OnItemClickListener {
            override fun onDetailClick(recipes: Recipes) {
                val go =
                    FavoriteFragmentDirections.actionFavoriteFragmentToRecipeInformationFragment(recipes.id)
                findNavController().navigate(go)
            }
        })


        lifecycleScope.launch {
            viewModel.getRecipes().collect{
                mAdapter.submitList(it)
            }
        }
    }

    private fun configDrawer() {
        val navController = findNavController()
        val drawerLayout = requireActivity().findViewById<DrawerLayout>(R.id.drawerLayout)
        val appConfig = AppBarConfiguration(navController.graph, drawerLayout)

//        binding.favoriteToolbar.setupWithNavController(navController, appConfig)
        binding.favoriteToolbar.setupWithNavController(findNavController())
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object{
        private const val TAG = "FavoriteFragment"
    }
}