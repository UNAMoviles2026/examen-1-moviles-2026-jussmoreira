package com.moviles.examenmoviles.ui.viewmodel

import com.moviles.examenmoviles.data.CoworkingRepository
import com.moviles.examenmoviles.model.CoworkingSpace

class SpacesViewModel(
    private val repository: CoworkingRepository = CoworkingRepository()
) {

    val spaces: List<CoworkingSpace> = repository.getSpaces()

    fun getSpaceById(spaceId: String): CoworkingSpace? = repository.getSpaceById(spaceId)

    fun reserveFeedback(space: CoworkingSpace): String = repository.buildReservationFeedback(space)
}

