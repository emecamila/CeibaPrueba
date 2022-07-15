package com.example.ceibaprueba.ui.view

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ceibaprueba.BaseUsersActivity
import com.example.ceibaprueba.databinding.ActivityDetailUserBinding
import com.example.ceibaprueba.domain.model.User
import com.example.ceibaprueba.ui.view.adapter.PostAdapter
import com.example.ceibaprueba.ui.viewmodel.UserDetailViewModel
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailActivity : BaseUsersActivity() {

    private lateinit var user: User
    private lateinit var binding: ActivityDetailUserBinding
    private val userDetailViewModel: UserDetailViewModel by viewModels()

    private lateinit var adapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        user = Gson().fromJson(intent.extras!!["user"]!!.toString(), User::class.java)
        userDetailViewModel.onCreate(user.id)

        binding.viewUser.tvName.text = user.name
        binding.viewUser.tvPhone.text = user.phone
        binding.viewUser.tvEmail.text = user.email

        userDetailViewModel.allPost.observe(this, Observer {
            adapter = PostAdapter(it)
            binding.rvPosts.layoutManager = LinearLayoutManager(this)
            binding.rvPosts.adapter = adapter
        })

        userDetailViewModel.isLoading.observe(this) {
            binding.pbPosts.visibility = if (it) View.VISIBLE else View.GONE
        }

    }
}