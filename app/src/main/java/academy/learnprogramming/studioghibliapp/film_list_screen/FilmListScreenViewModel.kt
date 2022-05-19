package academy.learnprogramming.studioghibliapp.film_list_screen

import academy.learnprogramming.studioghibliapp.data.remote.responses.FilmList
import academy.learnprogramming.studioghibliapp.repository.FilmRepository
import academy.learnprogramming.studioghibliapp.util.Constants.LIMIT
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
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
        loadFilmList()
    }

    private fun loadFilmList() {
        viewModelScope.launch {
            isLoading.value = true
            repository.getFilmList(limit = LIMIT)
                // on fail
              //  .catch {
                //    loadError.value = it.message.toString()
              //  }
                // on success
                .collect { newFilmList ->
                    filmList.value = newFilmList
                }
        }
        isLoading.value = false
    }
}

