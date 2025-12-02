package com.example.rentalmobilpnm

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarAdapter(private val cars: List<Car>) : RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivCar: ImageView = itemView.findViewById(R.id.ivCar)
        val tvBrand: TextView = itemView.findViewById(R.id.tvBrand)
        val tvModel: TextView = itemView.findViewById(R.id.tvModel)
        val tvPrice: TextView = itemView.findViewById(R.id.tvPrice)
        val btnRent: Button = itemView.findViewById(R.id.btnRent)   // ← pastikan ada di item_car.xml
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_car, parent, false)
        return CarViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val car = cars[position]

        holder.ivCar.setImageResource(car.image)
        holder.tvBrand.text = car.brand
        holder.tvModel.text = car.model
        holder.tvPrice.text = car.price

        // Aksi tombol untuk buka halaman detail
        holder.btnRent.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, CarDetailActivity::class.java)

            intent.putExtra("brand", car.brand)
            intent.putExtra("model", car.model)
            intent.putExtra("price", car.price)
            intent.putExtra("image", car.image)

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = cars.size
}
