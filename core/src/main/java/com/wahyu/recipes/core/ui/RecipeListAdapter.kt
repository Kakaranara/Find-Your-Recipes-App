package com.wahyu.recipes.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wahyu.recipes.core.databinding.ItemListRecipeBinding
import com.wahyu.recipes.core.model.Recipes

class RecipeListAdapter : ListAdapter<Recipes, RecipeListAdapter.ViewHolder>(DIFF_CALLBACK) {

    inner class ViewHolder(private val binding: ItemListRecipeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(recipes: Recipes) {
            binding.textView2.text = recipes.title
            Glide.with(binding.root.context)
                .load(recipes.image)
                .into(binding.imgRecipe)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = ItemListRecipeBinding.inflate(inflater, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Recipes>() {
            override fun areItemsTheSame(oldItem: Recipes, newItem: Recipes): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Recipes, newItem: Recipes): Boolean {
                return oldItem.title == newItem.title
            }
        }
    }
}