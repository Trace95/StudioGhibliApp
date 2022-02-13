package academy.learnprogramming.studioghibliapp.film_list_screen

import academy.learnprogramming.studioghibliapp.data.remote.responses.FilmList
import academy.learnprogramming.studioghibliapp.data.remote.responses.FilmListItem
import academy.learnprogramming.studioghibliapp.repository.FilmRepository
import academy.learnprogramming.studioghibliapp.util.Constants.LIMIT
import academy.learnprogramming.studioghibliapp.util.ResponseWrapper
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilmListScreenViewModel @Inject constructor(
    private val repository: FilmRepository,
) : ViewModel() {

    var filmList = mutableStateOf(FilmList())
    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)

    init {
       // loadFilmList()
    }


    private fun loadFilmList() {
        viewModelScope.launch {
            isLoading.value = true
            when (val result = repository.getFilmList(limit = LIMIT)) {
                is ResponseWrapper.Success -> {
                    // Should this be in its own function dedicated for mapping results?
                    filmList = result.data?.mapIndexed { _, film ->
                        FilmListItem(
                            description = film.description,
                            director = film.director,
                            id = film.id,
                            image = film.image,
                            locations = film.locations,
                            movie_banner = film.movie_banner,
                            original_title = film.original_title,
                            original_title_romanised = film.original_title_romanised,
                            people = film.people,
                            producer = film.producer,
                            release_date = film.release_date,
                            rt_score = film.rt_score,
                            running_time = film.running_time,
                            species = film.species,
                            title = film.title,
                            url = film.url,
                            vehicles = film.vehicles
                        )
                    } as MutableState<FilmList>
                }
                is ResponseWrapper.Error -> {
                    loadError.value = error(message = result)
                }
            }
        }
    }
}