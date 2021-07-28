package com.ruchajoshi.ktordemo.utils

import com.ruchajoshi.ktordemo.model.Post

sealed class ApiState{

    object Empty: ApiState()
    class Failure(val msg:Throwable):ApiState()
    class Success(val data:List<Post>):ApiState()
    object Loading :ApiState()

}
