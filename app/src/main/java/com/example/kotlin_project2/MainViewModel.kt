package com.example.kotlin_project2

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    //хранитть текущий фрагмент
    private val _currentFragment = MutableLiveData<Fragment>()
    val currentFragment: LiveData<Fragment> get() = _currentFragment

    //LiveData
    private val _navigateTo = MutableLiveData<Int>()
    val navigateTo: LiveData<Int> = _navigateTo

    //установка текущего фргмента
    fun setFragment(fragment: Fragment) {
        _currentFragment.value = fragment
    }

    fun navigateToFragment(actionId: Int) {
        _navigateTo.value = actionId
    }

    fun onNavigationComplete() {
        _navigateTo.value = null
    }
}
