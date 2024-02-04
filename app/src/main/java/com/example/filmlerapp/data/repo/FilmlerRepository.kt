package com.example.filmlerapp.data.repo

import com.example.filmlerapp.data.datasource.FilmlerDataSources
import com.example.filmlerapp.data.entity.Filmler

class FilmlerRepository {
    var fds = FilmlerDataSources()
    suspend fun filmleriYukle(): List<Filmler> = fds.filmleriYukle()
}