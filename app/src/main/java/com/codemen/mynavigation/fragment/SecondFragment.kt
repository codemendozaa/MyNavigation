package com.codemen.mynavigation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.codemen.mynavigation.R
import com.codemen.mynavigation.User
import kotlinx.android.synthetic.main.fragment_second.*


class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonThrirdFragment.setOnClickListener {
            val user = User("Android Dev Perú", "Gracias!! por tu atención..")
            findNavController().navigate(
                SecondFragmentDirections.actionSecondFragmentToThirdFragment(user)
            )
        }
    }

}
