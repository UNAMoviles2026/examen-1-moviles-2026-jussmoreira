package com.moviles.examenmoviles.data

import com.moviles.examenmoviles.model.CoworkingSpace

class CoworkingRepository {
    fun getSpaces(): List<CoworkingSpace> = MockData.spaces

    fun getSpaceById(spaceId: String): CoworkingSpace? =
        MockData.spaces.firstOrNull { it.id == spaceId }

    fun buildReservationFeedback(space: CoworkingSpace): String {
        return if (space.isAvailable) {
            "Reservation confirmed for ${space.name}."
        } else {
            "${space.name} is currently unavailable."
        }
    }
}

