package com.youtubekoleychik.testdatastore.forKeys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.youtubekoleychik.testdatastore.R
import kotlinx.android.synthetic.main.activity_preferences.*

class PreferencesActivity : AppCompatActivity() {
    private lateinit var viewModel: PreferencesViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferences)
        viewModel = ViewModelProvider(this)[PreferencesViewModel::class.java]

        viewModel.age.observe(this) { it ->
            textAge.text = it.toString()
        }

        viewModel.name.observe(this) { it ->
            textName.text = it
        }

        btn.setOnClickListener {
            viewModel.save(PreferencesKeys.name, edtName.text.toString())
            viewModel.save(PreferencesKeys.age, edtAge.text.toString().toInt())
        }
    }
}