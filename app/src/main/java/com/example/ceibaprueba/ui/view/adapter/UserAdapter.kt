package com.example.ceibaprueba.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ceibaprueba.R
import com.example.ceibaprueba.domain.model.User

class UserAdapter(private var users: List<User>, private val listener: AdapterClickListener) :
    RecyclerView.Adapter<UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return UserViewHolder(layoutInflater.inflate(R.layout.view_item_user, parent, false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item: User = users[position]
        holder.bind(item, listener)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    fun setNewList(newUsers: List<User>){
        users = newUsers
        notifyDataSetChanged()
    }
}