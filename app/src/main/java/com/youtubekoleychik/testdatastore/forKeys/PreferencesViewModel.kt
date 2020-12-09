package com.youtubekoleychik.testdatastore.forKeys

import android.app.Application
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PreferencesViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = PreferencesRepository(application.applicationContext)

    val age = repository.get(PreferencesKeys.age).asLiveData()

    val name = repository.get(PreferencesKeys.name).asLiveData()

    fun save(key: Preferences.Key<String>, value: String) = viewModelScope.launch {
        repository.save(key, value)
    }

    fun save(key: Preferences.Key<Int>, value: Int) = viewModelScope.launch {
        repository.save(key, value)
    }
}