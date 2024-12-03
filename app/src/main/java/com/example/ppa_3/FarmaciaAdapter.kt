package com.example.ppa_3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FarmaciaAdapter(private val farmacias: List<Farmacia>) :
    RecyclerView.Adapter<FarmaciaAdapter.FarmaciaViewHolder>() {

    class FarmaciaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title: TextView = itemView.findViewById(R.id.title)
    val telefono: TextView = itemView.findViewById(R.id.telefono)
    val coordinates: TextView = itemView.findViewById(R.id.coordinates)
    val image: ImageView = itemView.findViewById(R.id.farmacia_image)
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FarmaciaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_farmacia, parent, false)
        return FarmaciaViewHolder(view)
    }

    override fun onBindViewHolder(holder: FarmaciaViewHolder, position: Int) {
    val farmacia = farmacias[position]
    holder.title.text = farmacia.title
    holder.telefono.text = farmacia.telefono
    holder.coordinates.text = farmacia.coordinates.joinToString(", ")
    holder.image.setImageResource(R.drawable.farmacia_foto)
}

    override fun getItemCount() = farmacias.size
}