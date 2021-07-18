package com.example.myapplication.data.state
/**
 * @author Alex Volkov(Volkos)
 *
 * Класс состояний приложения
 */
sealed class AppState {
    data class Success<out T>(val data: T) : AppState()
    data class Loading(val progress: Int) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Empty : AppState()
}