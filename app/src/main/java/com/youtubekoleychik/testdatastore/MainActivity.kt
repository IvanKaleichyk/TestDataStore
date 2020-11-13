package com.youtubekoleychik.testdatastore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.age.observe(this, {
            textAge.text = it.toString()
        })

        viewModel.name.observe(this, {
            textName.text = it
        })

        btn.setOnClickListener {
            viewModel.save(PreferencesKeys.name, edtName.text.toString())
            viewModel.save(PreferencesKeys.age, edtAge.text.toString().toInt())
        }
    }
}