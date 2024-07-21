package navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Route(val path: String) {
    @Serializable
    data object Home : Route("home")

    @Serializable
    data class Threads(val board: String) : Route("threads/$board")
}