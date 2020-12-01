package com.youtubekoleychik.testdatastore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.youtubekoleychik.testdatastore.forKeys.PreferencesActivity
import com.youtubekoleychik.testdatastore.forProtoBuffers.ProtocolBufferActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPreferences.setOnClickListener {
            startActivity(Intent(this@MainActivity, PreferencesActivity::class.java))
        }

        btnProtocolBuffer.setOnClickListener {
            startActivity(Intent(this@MainActivity, ProtocolBufferActivity::class.java))
        }

    }
}