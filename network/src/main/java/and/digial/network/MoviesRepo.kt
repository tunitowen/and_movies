package and.digial.network

import and.digial.network.model.SearchResult

class MoviesRepo(private val api: MoviesApi) {

    suspend fun search(term: String): SearchResult {
        return api.search(term = term)
    }
}