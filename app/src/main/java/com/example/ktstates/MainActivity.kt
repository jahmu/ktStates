package com.example.ktstates

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ktstates.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var data: SharedPreferences
    lateinit var editdata: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        data = applicationContext.getSharedPreferences("mydata", MODE_PRIVATE)
        editdata = data.edit()

        Toast.makeText(applicationContext, "onCreate", Toast.LENGTH_SHORT).show()

        binding.save.setOnClickListener {
            saveData()
        }
        binding.retrieve.setOnClickListener {
            retrieveData()
        }
    }
    override fun onStart() {
        super.onStart()
        Toast.makeText(applicationContext,"onStart",Toast.LENGTH_SHORT).show()
    }
    override fun onResume() {
        super.onResume()
        //retreaving
        binding.message.setText(data.getString("message",""))
        Toast.makeText(applicationContext,"onResume",Toast.LENGTH_SHORT).show()
    }
    override fun onPause() {
        super.onPause()
        //save
        editdata.putString("message",binding.message.text.toString())
        editdata.apply()
        Toast.makeText(applicationContext,"onPause",Toast.LENGTH_SHORT).show()
    }
    override fun onStop() {
        super.onStop()
        Toast.makeText(applicationContext,"onStop",Toast.LENGTH_SHORT).show()
    }
    override fun onRestart() {
        super.onRestart()
        Toast.makeText(applicationContext, "onRestart", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(applicationContext,"onDestroy",Toast.LENGTH_SHORT).show()
    }

    fun saveData(){
        editdata.putString("message", binding.message.text.toString())
        editdata.apply()
    }
    fun retrieveData(){
        binding.message.setText(data.getString("message", ""))
    }
}
