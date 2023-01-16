package com.example.recipes.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
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

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<HomeViewModel>()

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

        viewModel.getRecipeList().observe(viewLifecycleOwner) {
            when (it) {
                is Async.Error -> {
                    binding.progressBar.gone()
                    it.data?.let { recipe ->
                        if(recipe.isEmpty()){
                            binding.tvHomeError.root.visible()
                            binding.tvHomeError.tvError.text = it.errorMessage
                        }
                        mAdapter.submitList(recipe)
                    } ?: binding.tvHomeError.root.visible()
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