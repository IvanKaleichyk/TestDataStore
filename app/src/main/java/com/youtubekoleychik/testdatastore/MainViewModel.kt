package com.youtubekoleychik.testdatastore

import android.app.Application
import androidx.datastore.preferences.Preferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = Repository(application.applicationContext)

    val age = repository.get(PreferencesKeys.age).asLiveData()

    val name = repository.get(PreferencesKeys.name).asLiveData()

    fun save(key: Preferences.Key<String>, value: String) = viewModelScope.launch {
        repository.save(key, value)
    }

    fun save(key: Preferences.Key<Int>, value: Int) = viewModelScope.launch {
        repository.save(key, value)
    }
}