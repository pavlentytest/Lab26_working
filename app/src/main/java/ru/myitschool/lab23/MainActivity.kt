package ru.myitschool.lab23

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    lateinit var mu: EditText
    lateinit var vari: EditText
    lateinit var btn: Button
    lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mu = findViewById(R.id.mean_val)
        vari = findViewById(R.id.variance_value)
        val provider = ViewModelProvider(this)
        viewModel = provider[MainViewModel::class.java]
        btn  = findViewById(R.id.get_random_num)
        tv = findViewById(R.id.random_number_result)
        btn.setOnClickListener {
            val m = mu.text.toString().toDouble()
            val v = vari.text.toString().toDouble()
            viewModel.setValue(Math.exp(Math.sqrt(v) * Random().nextGaussian() + m))
        }
        viewModel.value.observe(this) {
            tv.text = it.toString()
        }
    }
}