package com.codemen.mynavigation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.codemen.mynavigation.R
import kotlinx.android.synthetic.main.fragment_third.*

class ThirdFragment : Fragment() {
    private val args: ThirdFragmentArgs? by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        args?.user?.let {
            val datos = "\n\nName: ${it.name}" + "\nTitle:${it.title}"
            textArgs.append(datos)
        }
    }

}
