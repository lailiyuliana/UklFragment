package com.example.ukl

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_tampil.*

class Tampil : Fragment() {
    private var communicationViewModel: CommunicationViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        communicationViewModel = ViewModelProvider(requireActivity()).get(CommunicationViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tampil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        communicationViewModel!!.name.observe(requireActivity(), Observer{ s -> nameText.text = s })
        communicationViewModel!!.email.observe(requireActivity(), Observer{ s -> emailText.text = s })
        communicationViewModel!!.password.observe(requireActivity(), Observer{ s -> passText.text = s })
    }

    companion object {
        @JvmStatic
        fun newInstance() = Tampil()
    }
}