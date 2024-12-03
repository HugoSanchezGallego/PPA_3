package com.example.ppa_3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val farmacias = fetchFarmacias().map { feature ->
            Farmacia(
                title = feature.properties.title,
                telefono = feature.properties.description.split("Teléfono: ")[1].split(" ")[0],
                coordinates = feature.geometry.coordinates
            )
        }

        val adapter = FarmaciaAdapter(farmacias)
        recyclerView.adapter = adapter
    }
}