package com.gulsahozaltun.recyclerviewbirinciders

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.gulsahozaltun.recyclerviewbirinciders.databinding.FragmentAnasayfaBinding


class AnasayfaFragment : Fragment() {
    private lateinit var adapter: UlkelerAdapter
    private lateinit var ulkeListesi:ArrayList<Ulkeler>
    private lateinit var tasarim:FragmentAnasayfaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim= DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa, container, false)
        return tasarim.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tasarim.rv.layoutManager=LinearLayoutManager(requireContext())

        ulkeListesi= ArrayList()
        val u1=Ulkeler(1,"Türkiye","Ankara","Türk Lirası")
        val u2=Ulkeler(2,"Japonya","Tokyo","Japon Yeni")
        val u3=Ulkeler(3,"Fransa","Parid","Euro")
        val u4=Ulkeler(4,"Rusya","Moskova","Ruble")
        ulkeListesi.add(u1)
        ulkeListesi.add(u2)
        ulkeListesi.add(u3)
        ulkeListesi.add(u4)

        adapter= UlkelerAdapter(requireContext(),ulkeListesi)
        tasarim.rv.adapter=adapter


    }


}