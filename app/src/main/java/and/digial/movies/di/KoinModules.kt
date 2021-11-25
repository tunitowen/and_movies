package and.digial.movies.di

import and.digial.movies.ui.rabbit.RabbitViewModel
import and.digial.movies.ui.search.SearchViewModel
import and.digial.network.MoviesApi
import and.digial.network.MoviesRepo
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    viewModel { SearchViewModel(get()) }
    viewModel { RabbitViewModel(get()) }

    single { MoviesRepo(get()) }

    single { provideOkHttpClient() }
    single { provideRetrofitClient(get()) }
    single { provideMoviesApi(get()) }
}

fun provideRetrofitClient(okHttpClient: OkHttpClient): Retrofit {
    val BASE_URL = "https://api.themoviedb.org/3/"

    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
}

fun provideMoviesApi(retrofit: Retrofit): MoviesApi = retrofit.create(MoviesApi::class.java)

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder().build()
}