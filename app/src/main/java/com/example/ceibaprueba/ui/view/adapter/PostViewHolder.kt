package com.example.ceibaprueba.ui.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.ceibaprueba.databinding.ViewItemPostBinding
import com.example.ceibaprueba.domain.model.Post

class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ViewItemPostBinding.bind(view)

    fun bind(post: Post) {
        binding.tvTitle.text = post.title
        binding.tvBody.text = post.body
    }
}