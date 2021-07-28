package com.ruchajoshi.ktordemo.repo

import com.ruchajoshi.ktordemo.model.Post
import com.ruchajoshi.ktordemo.network.Api
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepo
@Inject
constructor(private val api:Api){

fun getPost(): Flow<List<Post>> = flow{
    emit (api.getPost())
}.flowOn(Dispatchers.IO)

}