package com.example.ceibaprueba.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ceibaprueba.domain.GetPostUseCase
import com.example.ceibaprueba.domain.GetUsersUseCase
import com.example.ceibaprueba.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeListViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase,
    private val getPostUseCase: GetPostUseCase
) :
    ViewModel() {

    val tempListModel = MutableLiveData<List<User>>()
    val allUsersModel = MutableLiveData<List<User>>()
    val isLoading = MutableLiveData<Boolean>()
    val isEmptyResult = MutableLiveData<Boolean>()

    fun onCreate() {
        isLoading.postValue(true)
        viewModelScope.launch {
            val result = getUsersUseCase()
            if (!result.isNullOrEmpty()) {
                allUsersModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

    fun filterList(term: String) {
        if (term.isEmpty()) {
            tempListModel.postValue(allUsersModel.value)
            return
        }
        val filteredList = allUsersModel.value!!.filter { it.name!!.contains(term, true) }
        tempListModel.postValue(filteredList)

        isEmptyResult.postValue(filteredList.isEmpty())
    }


}