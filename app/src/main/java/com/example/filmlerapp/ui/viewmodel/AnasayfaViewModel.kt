package com.example.filmlerapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.filmlerapp.data.entity.Filmler
import com.example.filmlerapp.data.repo.FilmlerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


class AnasayfaViewModel : ViewModel() {
    var frepo = FilmlerRepository()
    var filmlerListesi = MutableLiveData<List<Filmler>>()

    init {
        filmleriYukle()
    }
    fun filmleriYukle(){
        CoroutineScope(Dispatchers.Main).launch {
           filmlerListesi.value = frepo.filmleriYukle()
        }
    }
}