package academy.learnprogramming.studioghibliapp.util

sealed class ResponseWrapper<T>(val data: T? = null, message: String? = null) {
    class Success<T>(data: T) : ResponseWrapper<T>(data, null)
    class Error<T>(message: String, data: T? = null) : ResponseWrapper<T>(data, message)
}