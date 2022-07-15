package com.example.ceibaprueba.ui.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ceibaprueba.BaseUsersActivity
import com.example.ceibaprueba.databinding.ActivityHomeListBinding
import com.example.ceibaprueba.domain.model.Post
import com.example.ceibaprueba.domain.model.User
import com.example.ceibaprueba.ui.view.adapter.UserAdapter
import com.example.ceibaprueba.ui.view.adapter.AdapterClickListener
import com.example.ceibaprueba.ui.viewmodel.HomeListViewModel
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeListActivity : BaseUsersActivity(), SearchView.OnQueryTextListener,
    AdapterClickListener {

    private lateinit var binding: ActivityHomeListBinding
    private val homeListViewModel: HomeListViewModel by viewModels()

    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeListBinding.inflate(layoutInflater)
        binding.svUsers.setOnQueryTextListener(this)
        setContentView(binding.root)

        homeListViewModel.onCreate()

        homeListViewModel.allUsersModel.observe(this, Observer {
            adapter = UserAdapter(it, this)
            binding.rvUsers.layoutManager = LinearLayoutManager(this)
            binding.rvUsers.adapter = adapter
        })

        homeListViewModel.tempListModel.observe(this, Observer {
            adapter.setNewList(it)
        })

        homeListViewModel.isLoading.observe(this) {
            binding.pbUsers.visibility = if (it) VISIBLE else GONE
        }

        homeListViewModel.isEmptyResult.observe(this) {
            binding.tvEmpty.visibility = if (it) VISIBLE else GONE
            binding.rvUsers.visibility = if (it) GONE else VISIBLE
        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        homeListViewModel.filterList(newText!!.toString().trim())
        return true
    }

    override fun onUserRecyclerViewCLickListener(view: View, user: User) {
        val goDetail = Intent(this, UserDetailActivity::class.java)
        goDetail.putExtra("user", Gson().toJson(user))
        startActivity(goDetail)
    }

    override fun onClick(p0: View?) {
        // empty
    }
}