package academy.learnprogramming.studioghibliapp.di

import academy.learnprogramming.studioghibliapp.data.remote.GhibliApi
import academy.learnprogramming.studioghibliapp.repository.FilmRepository
import academy.learnprogramming.studioghibliapp.repository.FilmRepositoryImpl
import academy.learnprogramming.studioghibliapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideGhibliRepository(
        api: GhibliApi,
    ): FilmRepository = FilmRepositoryImpl(api)

    @Singleton
    @Provides
    fun providesGhibliApi(): GhibliApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(GhibliApi::class.java)
    }
}