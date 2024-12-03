package com.example.ppa_3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val db = FirebaseFirestore.getInstance()
        clearFarmaciasCollection(db) {
            val farmacias = fetchFarmacias(this).map { feature ->
                val telefono = feature.properties.description.split("Teléfono: ").getOrNull(1)?.split(" ")?.getOrNull(0) ?: "N/A"
                Farmacia(
                    title = feature.properties.title,
                    telefono = telefono,
                    description = feature.properties.description
                )
            }

            val adapter = FarmaciaAdapter(farmacias) { farmacia ->
                val intent = Intent(this, MapActivity::class.java)
                intent.putExtra("description", farmacia.description)
                startActivity(intent)
            }
            recyclerView.adapter = adapter
        }
    }

    private fun clearFarmaciasCollection(db: FirebaseFirestore, onComplete: () -> Unit) {
        db.collection("farmacias")
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    db.collection("farmacias").document(document.id).delete()
                }
                onComplete()
            }
            .addOnFailureListener { e ->
                println("Error clearing collection: $e")
                onComplete()
            }
    }
}