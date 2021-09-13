package com.gulsahozaltun.recyclerviewbirinciders

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.gulsahozaltun.recyclerviewbirinciders.databinding.CardTasarimBinding

class UlkelerAdapter(var mContext:Context,var ulkelerListesi:List<Ulkeler> ):RecyclerView.Adapter<UlkelerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(cardTasarimBinding: CardTasarimBinding):RecyclerView.ViewHolder(cardTasarimBinding.root){

        var cardTasarim:CardTasarimBinding
        init {
            this.cardTasarim=cardTasarimBinding
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim=CardTasarimBinding.inflate(layoutInflater,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val ulke=ulkelerListesi.get(position)
        val tasarim=holder.cardTasarim

        tasarim.ulkeAdi.text=ulke.ulke_adi
        tasarim.ulkeBaskenti.text=ulke.ulke_baskenti
        tasarim.ulkeParaBirimi.text=ulke.ulke_para_birimi

        tasarim.cardView.setOnClickListener {
            val gecis=AnasayfaFragmentDirections.maintoDetay(ulke)
            Navigation.findNavController(it).navigate(gecis)
        }

        tasarim.checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                Toast.makeText(mContext,"Favorilere eklendi!",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(mContext,"Favorilerden çıkartıldı!",Toast.LENGTH_SHORT).show()
            }

        }


    }

    override fun getItemCount(): Int {
        return ulkelerListesi.size
    }
}