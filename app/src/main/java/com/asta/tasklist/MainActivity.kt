package com.asta.tasklist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView2)
        val mainInput: EditText = findViewById(R.id.main_input)
        val mainOkayBtn: Button = findViewById(R.id.main_okay_btn)
        val deleteBtn: Button = findViewById(R.id.deleteBtn)

        val toDo: MutableList<String> = mutableListOf()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, toDo)
        listView.adapter = adapter


        listView.setOnItemClickListener { parent, view, position, id ->
            val text = listView.getItemAtPosition(position).toString()
            deleteBtn.setOnClickListener {
                adapter.remove(text)
                Toast.makeText(this, "$text was deleted", Toast.LENGTH_LONG)
            }



        }

        mainOkayBtn.setOnClickListener {
            val text = mainInput.text.toString().trim()
            if (text != ""){
                adapter.insert(text, 0)
            }
        }
    }
}