package com.gulsahozaltun.recyclerviewbirinciders

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.gulsahozaltun.recyclerviewbirinciders.databinding.FragmentDetayBinding


class DetayFragment : Fragment() {
    private lateinit var tasarim:FragmentDetayBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim=DataBindingUtil.inflate(inflater,R.layout.fragment_detay, container, false)
        return tasarim.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle:DetayFragmentArgs by navArgs()
        val gelenSonuc=bundle.ulkeObje
        tasarim.ulkeAdiDetay.text=gelenSonuc.ulke_adi
        tasarim.ulkeBaskentDetay.text=gelenSonuc.ulke_baskenti
        tasarim.ulkeParaBirimiDetay.text=gelenSonuc.ulke_para_birimi
    }


}