package com.youtubekoleychik.testdatastore.forKeys

import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.preferencesKey


object PreferencesKeys {
    val name: Preferences.Key<String> = preferencesKey("name")
    val age: Preferences.Key<Int> = preferencesKey("age")
}