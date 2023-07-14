package com.caperezh.stefaninichallenge.domain

import com.caperezh.stefaninichallenge.common.DataState
import com.caperezh.stefaninichallenge.data.model.GridModel
import kotlinx.coroutines.flow.Flow

interface HomeUseCase {
    suspend operator fun invoke(): Flow<DataState<List<GridModel>>>
}