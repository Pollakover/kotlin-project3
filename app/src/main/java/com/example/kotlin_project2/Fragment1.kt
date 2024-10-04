package com.example.kotlin_project2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController

class Fragment1 : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_1, container, false)

        //ViewModel
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        //FragmentManager
        view.findViewById<Button>(R.id.buttonFragmentManager).setOnClickListener {
            val fragment2 = Fragment2()
            viewModel.setFragment(fragment2)  // Устанавливаем новый фрагмент
        }
        val buttonNavigationAPI = view.findViewById<Button>(R.id.buttonNavigationAPI)

        /*buttonNavigationAPI.setOnClickListener {
            view.findNavController().navigate(R.id.action_fragment1_to_fragment2)
        }*/

        //Navigation API
            view.findViewById<Button>(R.id.buttonNavigationAPI).setOnClickListener {
            viewModel.navigateToFragment(R.id.action_fragment1_to_fragment2)
        }

        return view
    }
}



