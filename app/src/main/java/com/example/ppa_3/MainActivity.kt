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

        val farmacias = fetchFarmacias(this).map { feature ->
            val telefono = feature.properties.description.split("Teléfono: ").getOrNull(1)?.split(" ")?.getOrNull(0) ?: "N/A"
            Farmacia(
                title = feature.properties.title,
                telefono = telefono,
                coordinates = feature.geometry.coordinates
            )
        }

        val adapter = FarmaciaAdapter(farmacias)
        recyclerView.adapter = adapter
    }
}