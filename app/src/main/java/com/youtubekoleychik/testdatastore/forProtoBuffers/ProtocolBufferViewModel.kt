package com.youtubekoleychik.testdatastore.forProtoBuffers

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.youtubekoleychik.testdatastore.forProtoBuffers.ProtocolBufferRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProtocolBufferViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ProtocolBufferRepository(application.applicationContext)

    val protocolBufferData = repository.readProto.asLiveData()

    fun updateValue(firstName: String, lastName: String, age: Int) = viewModelScope.launch(
        Dispatchers.IO
    ) {
        repository.updateValue(firstName, lastName, age)
    }

}