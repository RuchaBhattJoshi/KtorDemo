package com.ruchajoshi.ktordemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ruchajoshi.ktordemo.repo.MainRepo
import com.ruchajoshi.ktordemo.utils.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(private val mainRepo: MainRepo): ViewModel() {

private val _apiStateFlow:MutableStateFlow<ApiState> = MutableStateFlow(ApiState.Empty)
    val apiStateFlow:StateFlow<ApiState> = _apiStateFlow

    fun getPost() = viewModelScope.launch {
        mainRepo.getPost()
            .onStart {
                _apiStateFlow.value = ApiState.Loading
            }
            .catch { e->
                _apiStateFlow.value = ApiState.Failure(e)
            }.collect { response->
                _apiStateFlow.value = ApiState.Success(response)
            }
    }

}