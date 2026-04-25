package com.moviles.examenmoviles.data

import com.moviles.examenmoviles.R
import com.moviles.examenmoviles.model.CoworkingSpace

object MockData {
    val spaces: List<CoworkingSpace> = listOf(
        CoworkingSpace(
            id = "space_1",
            name = "Innovation Hub",
            shortDescription = "Open room for collaborative teams.",
            fullDescription = "Bright open coworking area with natural light and ergonomic furniture. Great for team sessions, workshops, and brainstorming meetings.",
            location = "San Jose, Escazu",
            capacity = 10,
            pricePerHour = 15.0,
            isAvailable = true,
            imageRes = R.drawable.ic_burned_logo,
            amenities = listOf("WiFi", "Projector", "Coffee", "Whiteboard")
        ),
        CoworkingSpace(
            id = "space_2",
            name = "Focus Pod",
            shortDescription = "Private and silent personal workspace.",
            fullDescription = "Small private pod designed for deep work. Includes adjustable desk, office chair, and controlled ambient noise.",
            location = "Heredia, Downtown",
            capacity = 1,
            pricePerHour = 8.0,
            isAvailable = true,
            imageRes = R.drawable.ic_burned_logo,
            amenities = listOf("WiFi", "Power Outlet", "Desk Lamp")
        ),
        CoworkingSpace(
            id = "space_3",
            name = "Executive Boardroom",
            shortDescription = "Meeting room for strategic sessions.",
            fullDescription = "Large boardroom with conference table, video call support, and premium seating for high-level client meetings.",
            location = "Alajuela, Business Center",
            capacity = 14,
            pricePerHour = 30.0,
            isAvailable = false,
            imageRes = R.drawable.ic_burned_logo,
            amenities = listOf("WiFi", "Screen", "Video Call System", "Air Conditioning")
        )
    )
}

