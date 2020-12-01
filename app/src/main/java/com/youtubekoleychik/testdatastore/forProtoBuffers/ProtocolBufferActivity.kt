package com.youtubekoleychik.testdatastore.forProtoBuffers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.youtubekoleychik.testdatastore.R
import kotlinx.android.synthetic.main.activity_protokol_buffer.*

class ProtocolBufferActivity : AppCompatActivity() {

    private lateinit var viewModel: ProtocolBufferViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_protokol_buffer)
        viewModel = ViewModelProvider(this)[ProtocolBufferViewModel::class.java]

        btn.setOnClickListener {
            viewModel.updateValue(
                edtLastName.text. toString(),
                edtName.text.toString(),
                edtAge.text.toString().toInt()
            )
        }

         viewModel.protocolBufferData.observe(this, {
             textName.text = it.firstName
             textLastName.text = it.lastName
             textAge.text = it.age.toString()
         })

    }
}