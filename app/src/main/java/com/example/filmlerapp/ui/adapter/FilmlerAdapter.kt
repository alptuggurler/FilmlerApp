package com.example.filmlerapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.filmlerapp.R
import com.example.filmlerapp.data.entity.Filmler
import com.example.filmlerapp.databinding.CardTasarimBinding
import com.example.filmlerapp.databinding.FragmentAnasayfaBinding
import com.example.filmlerapp.ui.fragment.AnasayfaFragment
import com.example.filmlerapp.ui.fragment.AnasayfaFragmentDirections
import com.google.android.material.snackbar.Snackbar

class FilmlerAdapter(var mContext: Context, var filmlerListesi:List<Filmler>)
    : RecyclerView.Adapter<FilmlerAdapter.cardTasarimTutucu>()
{

    inner class cardTasarimTutucu(var tasarim: CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardTasarimTutucu {
        val binding:CardTasarimBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.card_tasarim, parent, false)
        return cardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: cardTasarimTutucu, position: Int) {
        val film = filmlerListesi.get(position)
        val t = holder.tasarim
        t.imageViewDetayFilm.setImageResource(
            mContext.resources.getIdentifier(film.resim,"drawable",mContext.packageName))

        t.filmNesnesi = film

        t.cardViewFilm.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.detayGecis(film = film)
            Navigation.findNavController(it).navigate(gecis)
        }

        t.buttonSepet.setOnClickListener {
            Snackbar.make(it,"${film.ad} Sepete Eklendi",Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        //kaçtane film gösterileceğini bildirir.
        return filmlerListesi.size
    }
}