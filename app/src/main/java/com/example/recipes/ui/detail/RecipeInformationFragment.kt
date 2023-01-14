package com.example.recipes.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.setupWithNavController
import com.bumptech.glide.Glide
import com.example.recipes.R
import com.example.recipes.databinding.FragmentRecipeInformationBinding
import com.example.recipes.helper.HtmlParser
import com.example.recipes.helper.gone
import com.example.recipes.helper.visible
import com.wahyu.recipes.core.data.Async
import com.wahyu.recipes.core.model.RecipeInformation
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class RecipeInformationFragment : Fragment() {
    private var _binding: FragmentRecipeInformationBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<RecipeInformationFragmentArgs>()
    private val viewModel by viewModels<RecipeInformationViewModel>()
    private var isLiked: Boolean? = null
    private var data : RecipeInformation? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecipeInformationBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = args.id

        binding.detailToolbar.setupWithNavController(findNavController())
        binding.fabFavorite.setOnClickListener {
            if (isLiked != null && isLiked == true) {
                viewModel.setAsUnfavorite(data!!)
            } else {
                viewModel.setAsFavorite(data!!)
            }
        }

        lifecycleScope.launch {
            viewModel.getRecipeInformation(id).collect { information ->
                when (information) {
                    is Async.Error -> {
                        binding.content.progressBar2.gone()
                        setupDataIfAvalaible(information.data as RecipeInformation)
                    }
                    is Async.Loading -> {
                        binding.content.progressBar2.visible()
                    }
                    is Async.Success -> {
                        binding.content.progressBar2.gone()
                        setupDataIfAvalaible(information.data as RecipeInformation)
                    }
                }
            }
        }
    }

    private fun setupDataIfAvalaible(information: RecipeInformation) {
        Log.w(TAG, "setupDataIfAvalaible: $information")
        isLiked = information.isFavorite
        data = information

        val summary = HtmlParser.parseHtml(information.summary)
        val instruction = HtmlParser.parseHtml(information.instruction)

        binding.content.apply {
            tvDetailTitle.text = information.title
            tvDetailSummary.text = summary
            tvDetailInstruction.text = instruction

            Glide.with(requireActivity())
                .load(information.image)
                .into(detailImage)
        }
        validateFavorite()

    }

    private fun validateFavorite(){
        if (isLiked != null && isLiked == true) {
            binding.fabFavorite.setImageDrawable(
                ContextCompat.getDrawable(
                    requireActivity(),
                    R.drawable.ic_baseline_favorite_24
                )
            )
        } else {
            binding.fabFavorite.setImageDrawable(
                ContextCompat.getDrawable(
                    requireActivity(),
                    R.drawable.ic_baseline_favorite_border_24
                )
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val TAG = "RecipeInformationFragme"
    }
}