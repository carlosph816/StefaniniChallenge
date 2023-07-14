package com.caperezh.stefaninichallenge.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.caperezh.stefaninichallenge.common.Category
import com.caperezh.stefaninichallenge.common.DataState
import com.caperezh.stefaninichallenge.data.model.GridModel
import com.caperezh.stefaninichallenge.domain.HomeUseCaseImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUserCaseImpl: HomeUseCaseImpl
) : ViewModel() {

    var globalList: MutableList<GridModel> = mutableListOf()
        private set

    var myList: MutableList<GridModel> = mutableStateListOf()
        private set

    var myItem: MutableState<GridModel> =  mutableStateOf(GridModel())
        private set

    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState: StateFlow<LoginState> = _loginState

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    private val _selectedCategory = MutableStateFlow<String?>(null)
    val selectedCategory: StateFlow<String?> = _selectedCategory

    var showLoader by mutableStateOf(false)
        private set

    var showDialog by mutableStateOf(false)
        private set
    val categories = listOf("All", "Category 1", "Category 2", "Category 3")

    init {
        getInformation()
    }

    private fun getInformation() = viewModelScope.launch {
        homeUserCaseImpl.invoke().collect { response ->
            showLoader = response is DataState.Loading
            when (response) {
                is DataState.Success -> {
                    globalList.addAll(response.data)
                    myList.addAll(response.data)
                }
                is DataState.Error -> {
                    _loginState.value = LoginState.Error(
                        response.error.cause
                    )
                }

                else -> {}
            }
        }
    }

    fun setSearchQuery(query: String) {
        myList.clear()
        _searchQuery.value = query
        val list = filterItems(globalList, searchQuery.value, selectedCategory.value)
        myList.addAll(list)
    }

    fun clearSelectedCategory() {
        _selectedCategory.value = null
    }

    fun showDialog(item: GridModel){
        myItem.value = item
        showDialog = true
    }

    fun dismissDialog(){
        showDialog = false
    }

    fun filterByCategory(category: Category) {
        if(category == Category.ALL){
            myList.clear()
            myList.addAll(globalList)
        }else{
            myList.clear()
            val list = filterItemsByCategory(globalList, category.categoryName)
            myList.addAll(list)
        }
    }

    private fun filterItemsByCategory(
        items: List<GridModel>,
        category: String?
    ): List<GridModel> {
        return items.filter { item ->
             item.category == category
        }
    }

    private fun filterItems(
        items: List<GridModel>,
        query: String,
        category: String?
    ): List<GridModel> {
        return items.filter { item ->
            item.name.contains(query, ignoreCase = true) &&
                    (category == null || item.category == category)
        }
    }
}

sealed class LoginState {
    object Idle : LoginState()
    object Success : LoginState()
    data class Error(val message: String) : LoginState()
}

