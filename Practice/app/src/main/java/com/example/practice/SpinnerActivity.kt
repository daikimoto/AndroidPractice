package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.ArrayAdapter
import com.example.practice.databinding.ActivitySpinnerBinding

class SpinnerActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySpinnerBinding

    // スピナー要素の配列（選択肢）
    private val spinnerItems = arrayOf("Spinner", "Android", "Apple", "Windows")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpinnerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // コンソール出力
        println(binding.root)

        // ArrayAdapter
        val adapter =
            ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, spinnerItems)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // spinnerにadapterをセット
        // View Binding
        binding.spinner.adapter = adapter

        // リスナーを登録
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            // アイテムが選択された時
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String
                // View Binding
                //binding.textView.text = item
            }

            // アイテムが選択されなかった
            override fun onNothingSelected(parent: AdapterView<*>?) {
                // 参考：https://akira-watson.com/android/kotlin/spinner-simple.html#3
            }
        }
    }
}