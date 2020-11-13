package com.youtubekoleychik.testdatastore

import android.content.Context
import android.os.Parcelable
import android.preference.Preference
import androidx.datastore.preferences.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class Repository(context : Context) {

    private val dataStore = context.createDataStore("SOME_NAME")

    fun get(key : Preferences.Key<String>, basicValue : String = ""): Flow<String> = dataStore.data
        .map { preferences ->
            preferences[key] ?: basicValue
        }

    fun get(key: Preferences.Key<Int>, basicValue: Int = 0) : Flow<Int> = dataStore.data
        .map { preferences ->
            preferences[key] ?: basicValue
        }

    suspend fun save(key : Preferences.Key<String>, value: String){
        dataStore.edit { settings ->
            settings[key] = value
        }
    }

    suspend fun save(key : Preferences.Key<Int>, value: Int){
        dataStore.edit { settings ->
            settings[key] = value
        }
    }

}