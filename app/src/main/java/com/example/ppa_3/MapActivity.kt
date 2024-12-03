package com.example.ppa_3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MapActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        val description = intent.getStringExtra("description")
        if (description != null) {
            val uri = Uri.parse("https://www.google.com/maps/search/?api=1&query=${Uri.encode(description)}")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }
}