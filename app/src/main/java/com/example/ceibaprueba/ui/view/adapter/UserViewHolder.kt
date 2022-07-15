package com.example.ceibaprueba.ui.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.ceibaprueba.databinding.ViewItemUserBinding
import com.example.ceibaprueba.domain.model.User

class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ViewItemUserBinding.bind(view)

    fun bind(user: User, listener: AdapterClickListener) {
        binding.tvName.text = user.name
        binding.tvPhone.text = user.phone
        binding.tvEmail.text = user.email
        binding.tvBtnPosts.visibility = View.VISIBLE
        binding.tvBtnPosts.setOnClickListener {
            listener.onUserRecyclerViewCLickListener(
                binding.tvBtnPosts,
                user
            )
        }
    }
}