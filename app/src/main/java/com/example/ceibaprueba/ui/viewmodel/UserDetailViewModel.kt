package com.example.ceibaprueba.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ceibaprueba.domain.GetPostByUserUseCase
import com.example.ceibaprueba.domain.model.Post
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private val getPostByUserUseCase: GetPostByUserUseCase
) :
    ViewModel() {

    val allPost = MutableLiveData<List<Post>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate(idUser: Long) {
        isLoading.postValue(true)
        viewModelScope.launch {
            val result = getPostByUserUseCase(idUser)
            if (!result.isNullOrEmpty()) {
                allPost.postValue(result)
                isLoading.postValue(false)
            }
        }
    }
}