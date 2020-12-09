package com.youtubekoleychik.testdatastore.forProtoBuffers

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.createDataStore
import com.example.protodatastoretest.Person
import com.youtubekoleychik.testdatastore.forProtoBuffers.PersonSerializer
import kotlinx.coroutines.flow.Flow

class ProtocolBufferRepository(context: Context) {

    private val dataStore: DataStore<Person> = context.createDataStore(
        "person_data",
        serializer = PersonSerializer
    )

    val readProto: Flow<Person> = dataStore.data

    suspend fun updateValue(firstName: String, lastName: String, age: Int){
        dataStore.updateData { preference->
            preference.toBuilder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAge(age)
                .build()
        }
    }

}