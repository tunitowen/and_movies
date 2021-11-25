package and.digial.network.model

import com.google.gson.annotations.SerializedName

data class SearchResult(
    val results: List<MovieResult>
)

data class MovieResult(
    val id: Int,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    val title: String,
    val overview: String,
    @SerializedName("release_date")
    val releaseDate: String
)