package com.example.ceibaprueba.ui.view.adapter

import android.view.View
import com.example.ceibaprueba.domain.model.Post
import com.example.ceibaprueba.domain.model.User

interface AdapterClickListener : View.OnClickListener {

    fun onUserRecyclerViewCLickListener(view: View, user:User)
}