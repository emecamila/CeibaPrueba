package com.example.ceibaprueba.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ceibaprueba.R
import com.example.ceibaprueba.domain.model.Post
import com.example.ceibaprueba.domain.model.User

class PostAdapter(private var posts: List<Post>) :
    RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PostViewHolder(layoutInflater.inflate(R.layout.view_item_post, parent, false))
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val item: Post = posts[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return posts.size
    }
}