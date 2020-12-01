package com.youtubekoleychik.testdatastore.forProtoBuffers

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.example.protodatastoretest.Person
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

object PersonSerializer : Serializer<Person> {
    override val defaultValue: Person = Person.getDefaultInstance()

    override fun readFrom(input: InputStream): Person {
        try {
            return Person.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override fun writeTo(
        t: Person,
        output: OutputStream) = t.writeTo(output)
}