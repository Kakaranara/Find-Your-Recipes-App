package com.example.recipes.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.recipes.R
import com.example.recipes.databinding.FragmentRecipeInformationBinding


class RecipeInformationFragment : Fragment() {
    private var _binding: FragmentRecipeInformationBinding? = null
    private val binding: FragmentRecipeInformationBinding = _binding!!

//    private val args by navArgs<RecipeInformationFragmentArgs>()

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
//        val id = args.id
//
//        Toast.makeText(requireActivity(), id, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}