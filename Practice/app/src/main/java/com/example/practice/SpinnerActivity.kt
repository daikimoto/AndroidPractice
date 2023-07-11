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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)

        var user_name_tv = findViewById<TextView>(R.id.user_name_tv)
        var spinner = findViewById<Spinner>(R.id.spinner)

        //xmlファイルからアイテムの配列を取得
        val items = resources.getStringArray(R.array.user_items)

        //アダプターにアイテム配列を設定
        val Adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)

        //スピナーにアダプターを設定
        spinner.adapter = Adapter

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
            }
        }

    }
}