package com.example.viewmodel_exemple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmexemple.MainViewModel
import com.example.viewmodel_exemple.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setListener()
        setObserver()
    }

    private fun setObserver() {
        viewModel.countLiveData.observe(
            this,
            {
                binding.count.text = it.toString() //it은 Livedata<Int>의 Int
            }
        )
    }

    private fun setListener() {
        binding.run {
            plus.setOnClickListener() {
                viewModel.plus()
                Toast.makeText(this@MainActivity, "+ 1", Toast.LENGTH_SHORT).show()
            }
            minus.setOnClickListener() {
                viewModel.minus()
                Toast.makeText(this@MainActivity, "- 1", Toast.LENGTH_SHORT).show()
            }
            multiply.setOnClickListener() {
                viewModel.multiply()
                Toast.makeText(this@MainActivity, "* 3", Toast.LENGTH_SHORT).show()
            }
            division.setOnClickListener() {
                viewModel.division()
                Toast.makeText(this@MainActivity, "/ 3", Toast.LENGTH_SHORT).show()
            }
            clear.setOnClickListener() {
                viewModel.clear()
                Toast.makeText(this@MainActivity, "Clear", Toast.LENGTH_SHORT).show()
            }
        }

    }



}