package com.example.customexceptions.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.customexceptions.databinding.ActivityMainBinding
import com.example.customexceptions.presentation.MyApplication
import com.example.customexceptions.presentation.MyViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var  viewmodel:MyViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val appContainer = (application as MyApplication).container
        viewmodel=ViewModelProvider(this,appContainer.loginViewModelFactory).get(MyViewModel::class.java)
        observeCategories()
    }
    fun observeCategories(){
        binding.FetchDataBTN.setOnClickListener { viewmodel.getCategories() }
        viewmodel.categories.observe(this, { categories -> binding.categoryTV.text = categories.get(0).name },)
        viewmodel.error.observe(this, { error -> binding.errorTV.text=error })
    }
}