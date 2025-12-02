package com.example.rentalmobilpnm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Pastikan Car.kt ada di package yang sama (com.example.rentalmobilpnm)
// sehingga tidak perlu import manual, atau gunakan import yang benar jika beda package.

class CarAdapter(private val cars: List<Car>) : RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    // ViewHolder untuk item mobil
    class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivCar: ImageView = itemView.findViewById(R.id.ivCar)
        val tvBrand: TextView = itemView.findViewById(R.id.tvBrand)
        val tvModel: TextView = itemView.findViewById(R.id.tvModel)
        val tvPrice: TextView = itemView.findViewById(R.id.tvPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_car, parent, false)
        return CarViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val car = cars[position]

        // tampilkan data mobil
        holder.ivCar.setImageResource(car.image)   // image harus bertipe Int (R.drawable.xxx)
        holder.tvBrand.text = car.brand
        holder.tvModel.text = car.model
        holder.tvPrice.text = car.price
    }

    override fun getItemCount(): Int = cars.size
}
