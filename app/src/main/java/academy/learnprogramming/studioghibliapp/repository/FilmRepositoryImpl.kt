package academy.learnprogramming.studioghibliapp.repository

import academy.learnprogramming.studioghibliapp.data.remote.GhibliApi
import academy.learnprogramming.studioghibliapp.data.remote.responses.FilmList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(
    private val api: GhibliApi
) : FilmRepository {

    private val _filmDataStateFlow = MutableStateFlow(Result.success(FilmList()))
    override val filmDataStateFlow get() = _filmDataStateFlow.asStateFlow()

    override suspend fun fetchFilmListFromAPI(limit: Int) {
        _filmDataStateFlow.value = Result.success(api.getGhibliFilmList(limit))
    }

    suspend fun updateLocalCache() {
        // TODO: Implement room database
    }


}

