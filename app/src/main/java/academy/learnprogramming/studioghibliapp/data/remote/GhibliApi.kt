package academy.learnprogramming.studioghibliapp.data.remote

import academy.learnprogramming.studioghibliapp.data.remote.responses.FilmList
import academy.learnprogramming.studioghibliapp.data.remote.responses.FilmListItem
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GhibliApi {

    // max limit is 250
    @GET("films")
    suspend fun getGhibliFilmList(
        @Query("limit") limit: Int,
    ): FilmList

    @GET("films/{id}")
    suspend fun getFilmById(
        @Path("id") id: String
    ) : FilmListItem
}