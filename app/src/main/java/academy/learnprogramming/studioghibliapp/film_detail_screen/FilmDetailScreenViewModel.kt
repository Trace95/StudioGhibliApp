package academy.learnprogramming.studioghibliapp.film_detail_screen

import academy.learnprogramming.studioghibliapp.data.remote.responses.FilmListItem
import academy.learnprogramming.studioghibliapp.repository.FilmRepository
import academy.learnprogramming.studioghibliapp.util.FilmItemDummy
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FilmDetailScreenViewModel @Inject constructor(
    private val repository: FilmRepository,
    private val filmId: String
) : ViewModel() {

    var filmListItem = mutableStateOf(FilmItemDummy.item)

    fun getFilmListItemById(id: String) : FilmListItem {
        for (film in repository.filmDataStateFlow.value.)
    }

}