package academy.learnprogramming.studioghibliapp.repository


import academy.learnprogramming.studioghibliapp.data.remote.responses.FilmList
import academy.learnprogramming.studioghibliapp.util.Constants.LIMIT
import kotlinx.coroutines.flow.StateFlow


interface FilmRepository {
    val filmDataStateFlow : StateFlow<Result<FilmList>>
    suspend fun fetchFilmListFromAPI(limit: Int = LIMIT)
}