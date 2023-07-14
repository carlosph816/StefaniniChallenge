package com.caperezh.stefaninichallenge.data.model.repository

import com.caperezh.stefaninichallenge.common.DataState
import com.caperezh.stefaninichallenge.data.model.GridModel
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun getHomeInformation() : Flow<DataState<List<GridModel>>>
}