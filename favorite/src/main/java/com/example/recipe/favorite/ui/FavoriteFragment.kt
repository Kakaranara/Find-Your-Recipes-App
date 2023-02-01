package com.example.recipe.favorite.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recipe.favorite.databinding.FragmentFavoriteBinding
import com.example.recipe.favorite.di.DaggerFavoriteComponent
import com.example.recipes.di.FavoriteModuleDependencies
import com.example.recipes.helper.visible
import com.wahyu.recipes.core.model.Recipes
import com.wahyu.recipes.core.ui.RecipeListAdapter
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class FavoriteFragment : Fragment() {
    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var factory: ViewModelFactory

    private val viewModel by viewModels<FavoriteViewModel> {
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
                val uri = "android-app://com.wahyu.recipes/info/${recipes.id}".toUri()
                val request = NavDeepLinkRequest.Builder
                    .fromUri(uri)
                    .build()
                findNavController().navigate(request)
//                val go =
//                    FavoriteFragmentDirections.actionFavoriteFragment2ToRecipeInformationFragment2(
//                        recipes.id
//                    )
//                findNavController().navigate(go)
            }
        })

        viewModel.getRecipes().observe(viewLifecycleOwner) {
            if (it.isEmpty()) {
                binding.viewEmpty.root.visible()
            }
            mAdapter.submitList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}