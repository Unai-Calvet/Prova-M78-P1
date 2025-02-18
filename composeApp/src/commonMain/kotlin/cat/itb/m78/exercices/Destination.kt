package cat.itb.m78.exercices

import kotlinx.serialization.Serializable

object Destination {
    @Serializable
    data object ScreenCalculator
    @Serializable
    data class ScreenEnd(val result: Int)
}
