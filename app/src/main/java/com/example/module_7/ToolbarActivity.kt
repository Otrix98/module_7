package com.example.module_7

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_scrolling.*

class ToolbarActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        toolbar.setNavigationOnClickListener {
            Toast.makeText(this, "Navigation clicked", Toast.LENGTH_SHORT).show()
        }
    }
}