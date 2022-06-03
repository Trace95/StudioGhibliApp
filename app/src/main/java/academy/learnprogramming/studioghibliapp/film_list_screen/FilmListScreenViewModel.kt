package academy.learnprogramming.studioghibliapp.film_list_screen

import academy.learnprogramming.studioghibliapp.data.remote.responses.FilmList
import academy.learnprogramming.studioghibliapp.repository.FilmRepository
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilmListScreenViewModel @Inject constructor(
    private val repository: FilmRepository
) : ViewModel() {

    var filmList = mutableStateOf(FilmList())
    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)

    init {
        getFilmList()
        updateFilmList()
    }

    private fun getFilmList() {
        viewModelScope.launch {
            isLoading.value = true
            repository.filmDataStateFlow.collect { result ->
                result.fold(
                    { newFilmList -> filmList.value = newFilmList },
                    { exception -> loadError.value = exception.message.toString() })
            }
            isLoading.value = false
        }
    }

    private fun updateFilmList() {
        viewModelScope.launch {
            repository.fetchFilmListFromAPI()
        }
    }

}

