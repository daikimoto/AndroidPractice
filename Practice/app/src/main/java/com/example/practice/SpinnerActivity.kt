package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.practice.databinding.ActivitySpinnerBinding

class SpinnerActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySpinnerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySpinnerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var user_name_tv = binding.userNameTv
        var spinner = binding.spinner

        //xmlファイルからアイテムの配列を取得
        val items = resources.getStringArray(R.array.user_items)

        //アダプターにアイテム配列を設定
        val spinner_adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)

        //スピナーにアダプターを設定
        spinner.adapter = spinner_adapter

        //スピナーのセレクトイベント設定
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                //選択されたアイテムをテキストビューに設定
                val userName = parent.getItemAtPosition(position);
                user_name_tv.text = userName.toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            //
            }
        }

    }
}