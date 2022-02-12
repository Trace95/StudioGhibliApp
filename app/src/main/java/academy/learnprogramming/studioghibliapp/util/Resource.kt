package academy.learnprogramming.studioghibliapp.util

sealed class Resource<T>(val data: T? = null, message: String? = null) {
    class Success<T>(data: T) : Resource<T>(data, null)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
    class Loading<T>(data: T? = null) : Resource<T>(data)
}