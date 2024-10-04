package com.example.kotlin_project2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

import androidx.lifecycle.ViewModelProvider

class Fragment3 : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_3, container, false)

        //ViewModel
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        //FragmentManager
        view.findViewById<Button>(R.id.buttonFragmentManager).setOnClickListener {
            val fragment1 = Fragment1()
            viewModel.setFragment(fragment1)
        }

        val buttonNavigationAPI = view.findViewById<Button>(R.id.buttonNavigationAPI)

        //Navigation API
        buttonNavigationAPI.setOnClickListener {
            viewModel.navigateToFragment(R.id.action_fragment3_to_fragment1)
        }

        //buttonNavigationAPI.setOnClickListener {
        //    view.findNavController().navigate(R.id.action_fragment3_to_fragment1)
        //}

        view.findViewById<Button>(R.id.buttonNavigationAPI).setOnClickListener {
            viewModel.navigateToFragment(R.id.action_fragment3_to_fragment1)
        }

        return view
    }
}

