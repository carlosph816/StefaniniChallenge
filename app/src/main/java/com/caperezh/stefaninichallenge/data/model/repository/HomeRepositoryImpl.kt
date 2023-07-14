package com.caperezh.stefaninichallenge.data.model.repository

import com.caperezh.stefaninichallenge.common.BaseError
import com.caperezh.stefaninichallenge.common.DataState
import com.caperezh.stefaninichallenge.common.ItemsProvider
import com.caperezh.stefaninichallenge.common.ItemsProvider.Companion.itemsResponseJson
import com.caperezh.stefaninichallenge.data.model.GridModel
import com.google.gson.Gson
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(): HomeRepository{

    override suspend fun getHomeInformation(): Flow<DataState<List<GridModel>>> = flow {
        emit(DataState.Loading)
        delay(ItemsProvider.timeResponse)
        val response = ItemsProvider.getStatusCodeRandom()
        if(response.code == ItemsProvider.code){
            val myGson = Gson()
            val myResponse = myGson.fromJson(itemsResponseJson, Array<GridModel>::class.java).toList()
            emit(DataState.Success(myResponse))
        }else{
            emit(DataState.Error(BaseError()))
        }
    }
}