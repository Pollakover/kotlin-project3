package com.example.kotlin_project2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {

    //ViewModel
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //подписка на изменение фрагмента (FragmentManager)
        mainViewModel.currentFragment.observe(this, Observer { fragment ->
            replaceFragment(fragment)
        })

        //подписка на изменение фрагмента (NavigationAPI)
        mainViewModel.navigateTo.observe(this, Observer { actionId ->
            actionId?.let {
                val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as? NavHostFragment
                navHostFragment?.navController?.let { navController ->
                    navController.navigate(it)
                }
                mainViewModel.onNavigationComplete()
            }
        })
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}

