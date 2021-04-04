package com.youtubekoleychik.testdatastore.forKeys

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore


object PreferencesKeys {

    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "SOME_NAME")

    val name = stringPreferencesKey("name")
    val age = intPreferencesKey("age")
}