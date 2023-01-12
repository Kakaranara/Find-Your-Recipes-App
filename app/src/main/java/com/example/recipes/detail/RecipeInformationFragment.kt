package com.example.recipes.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.recipes.R
import com.example.recipes.databinding.FragmentRecipeInformationBinding
import com.example.recipes.helper.gone
import com.example.recipes.helper.visible
import com.wahyu.recipes.core.data.Async
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class RecipeInformationFragment : Fragment() {
    private var _binding: FragmentRecipeInformationBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<RecipeInformationFragmentArgs>()
    private val viewModel by viewModels<RecipeInformationViewModel>()

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

        lifecycleScope.launch {
            viewModel.getRecipeInformation(id).collect { information ->
                when (information) {
                    is Async.Error -> {
                        binding.progressBar2.gone()
                        Glide.with(view)
                            .load(information.data?.image)
                            .into(binding.detailImage)
                    }
                    is Async.Loading -> {
                        binding.progressBar2.visible()
                    }
                    is Async.Success -> {
                        binding.progressBar2.gone()
                        Glide.with(view)
                            .load(information.data?.image)
                            .into(binding.detailImage)
                    }
                }
            }
        }

        Toast.makeText(requireActivity(), "id: $id", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}