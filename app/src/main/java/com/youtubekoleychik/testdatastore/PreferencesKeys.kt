package com.youtubekoleychik.testdatastore

import androidx.datastore.preferences.Preferences
import androidx.datastore.preferences.preferencesKey

object PreferencesKeys {
    val name: Preferences.Key<String> = preferencesKey<String>("name")
    val age: Preferences.Key<Int> = preferencesKey<Int>("age")
}