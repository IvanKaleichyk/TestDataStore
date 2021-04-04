package com.youtubekoleychik.testdatastore.forKeys

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.youtubekoleychik.testdatastore.forKeys.PreferencesKeys.dataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PreferencesRepository(context: Context) {


    private val dataStore = context.dataStore

    fun get(key: Preferences.Key<String>, basicValue: String = ""): Flow<String> = dataStore.data
        .map { preferences ->
            preferences[key] ?: basicValue
        }

    fun get(key: Preferences.Key<Int>, basicValue: Int = 0): Flow<Int> = dataStore.data
        .map { preferences ->
            preferences[key] ?: basicValue
        }

    suspend fun save(key: Preferences.Key<String>, value: String) {
        dataStore.edit { settings ->
            settings[key] = value
        }
    }

    suspend fun save(key: Preferences.Key<Int>, value: Int) {
        dataStore.edit { settings ->
            settings[key] = value
        }
    }

}