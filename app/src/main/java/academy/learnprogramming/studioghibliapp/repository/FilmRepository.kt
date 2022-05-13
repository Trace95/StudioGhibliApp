package academy.learnprogramming.studioghibliapp.repository

import academy.learnprogramming.studioghibliapp.data.remote.GhibliApi
import academy.learnprogramming.studioghibliapp.data.remote.responses.FilmList
import academy.learnprogramming.studioghibliapp.data.remote.responses.FilmListItem
import academy.learnprogramming.studioghibliapp.util.ResponseWrapper
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class FilmRepository @Inject constructor(
    private val api: GhibliApi,
) {
    suspend fun getFilmList(limit: Int): ResponseWrapper<FilmList> {
        val response = try {
            api.getGhibliFilmList(limit)
        } catch (e: Exception) {
            return ResponseWrapper.Error(e.message.toString())
        }
        return ResponseWrapper.Success(response)
    }

    suspend fun getFilmById(id: String): ResponseWrapper<FilmListItem> {
        val response = try {
            api.getFilmById(id)
        } catch (e: Exception) {
            return ResponseWrapper.Error(e.message.toString())
        }
        return ResponseWrapper.Success(response)
    }
}