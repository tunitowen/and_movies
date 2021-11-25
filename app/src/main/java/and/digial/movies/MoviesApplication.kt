package and.digial.movies

import and.digial.movies.di.appModule
import android.app.Application
import org.koin.core.context.startKoin

class MoviesApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            modules(appModule)
        }
    }
}