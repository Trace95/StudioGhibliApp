package academy.learnprogramming.studioghibliapp.repository

import academy.learnprogramming.studioghibliapp.data.remote.GhibliApi
import academy.learnprogramming.studioghibliapp.data.remote.responses.FilmList
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ActivityScoped
class FilmRepository @Inject constructor(
    private val api: GhibliApi
) {
    suspend fun getFilmList(limit: Int): Flow<FilmList> {
            return api.getGhibliFilmList(limit)
    }
}