package and.digial.movies.ui.search

import and.digial.network.MoviesRepo
import and.digial.network.model.SearchResult
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SearchViewModel(private val repo: MoviesRepo): ViewModel() {

    val searchResult = MutableLiveData<SearchResult>()

    fun search(term: String) {
        viewModelScope.launch {
            val result = repo.search(term)
            println(result.toString())
            searchResult.value = result
        }

    }
}