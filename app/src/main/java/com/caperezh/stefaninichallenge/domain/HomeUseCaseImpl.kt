package com.caperezh.stefaninichallenge.domain

import com.caperezh.stefaninichallenge.data.model.repository.HomeRepositoryImpl
import javax.inject.Inject

class HomeUseCaseImpl @Inject constructor(
    private val homeRepository: HomeRepositoryImpl
): HomeUseCase{
    override suspend operator fun invoke() = homeRepository.getHomeInformation()
}