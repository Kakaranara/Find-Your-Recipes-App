package com.example.recipe.favorite

import android.os.Bundle
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
import com.example.recipe.favorite.databinding.FragmentFavoriteBinding
import com.example.recipes.R
import com.example.recipes.di.FavoriteModuleDependencies
import com.wahyu.recipes.core.model.Recipes
import com.wahyu.recipes.core.ui.RecipeListAdapter
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.EntryPointAccessors
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoriteFragment : Fragment() {
    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var factory: ViewModelFactory

    val viewModel by viewModels<FavoriteViewModel> {
        factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerFavoriteComponent.builder()
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    requireActivity().applicationContext,
                    FavoriteModuleDependencies::class.java
                )
            )
            .build()
            .inject(this)
    }

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
                    FavoriteFragmentDirections.actionFavoriteFragment2ToRecipeInformationFragment2(recipes.id)
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

    companion object {
        private const val TAG = "FavoriteFragment"
    }
}