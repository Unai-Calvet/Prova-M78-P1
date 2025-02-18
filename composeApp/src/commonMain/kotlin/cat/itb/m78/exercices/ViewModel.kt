package cat.itb.m78.exercices

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AppViewModel : ViewModel() {
    val resultNumber = mutableStateOf(0)
    val addType = mutableStateOf("+")
    fun changeTypeTo(new: String) {
        addType.value = new
    }

    fun add(value: String) {
        when (addType.value) {
            "+" -> resultNumber.value += value.toInt()
            "-" -> resultNumber.value -= value.toInt()
            "*" -> resultNumber.value *= value.toInt()
            "/" -> resultNumber.value /= value.toInt()
        }
    }
}
