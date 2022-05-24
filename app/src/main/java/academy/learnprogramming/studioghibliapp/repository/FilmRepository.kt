package academy.learnprogramming.studioghibliapp.repository

import academy.learnprogramming.studioghibliapp.data.remote.GhibliApi
import academy.learnprogramming.studioghibliapp.data.remote.responses.FilmList
import academy.learnprogramming.studioghibliapp.util.Constants.LIMIT
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@ActivityScoped
class FilmRepository @Inject constructor(
    private val api: GhibliApi
) {
    suspend fun getFilmList(limit: Int = LIMIT): Flow<Result<FilmList>> {
        return flow {
            emit(Result.success(api.getGhibliFilmList(limit)))
        }.catch { throwable ->
            Result.failure<Throwable>(throwable)
        }
    }
}

