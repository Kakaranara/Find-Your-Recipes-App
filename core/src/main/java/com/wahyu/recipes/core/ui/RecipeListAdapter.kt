package com.wahyu.recipes.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

//class RecipeListAdapter : RecyclerView.Adapter<RecipeListAdapter.ViewHolder>() {
//
//    inner class ViewHolder(private val binding: ItemListRecipeBinding) : RecyclerView.ViewHolder(binding.root) {
//        fun bind() {
//            Glide.with(binding.root.context)
//                .load("https://spoonacular.com/recipeImages/661886-312x231.jpg")
//                .into(binding.imgRecipe)
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        val view = ItemListRecipeBinding.inflate(inflater, parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind()
//    }
//
//    override fun getItemCount(): Int = 10
//}