package com.example.practice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import com.example.practice.databinding.ActivityMainBinding


class MainActivity: AppCompatActivity() {

    private lateinit var  binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toSpinnerButton.setOnClickListener {
            val intent = Intent(application,SpinnerActivity::class.java)
            startActivity(intent)
        }
    }
}