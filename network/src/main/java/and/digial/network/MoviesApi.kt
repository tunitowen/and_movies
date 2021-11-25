package and.digial.network

import and.digial.network.model.SearchResult
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "694f7d553d42c09d67298d5f7fe0eeac"

interface MoviesApi {

    @GET("search/movie")
    suspend fun search(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("query") term: String
    ): SearchResult
}