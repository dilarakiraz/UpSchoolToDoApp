package com.dilarakiraz.upschooltodoo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dilarakiraz.upschooltodoo.common.viewBinding
import com.dilarakiraz.upschooltodoo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding (ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}