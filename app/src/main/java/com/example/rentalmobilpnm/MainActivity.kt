package com.example.rentalmobilpnm

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class Car(
    val brand: String,
    val model: String,
    val price: String,
)

class MainActivity : AppCompatActivity() {

    private val carList = listOf(
        Car("Honda", "Civic Turbo", "Rp 650.000/hari"),
        Car("Toyota", "Fortuner VRZ", "Rp 900.000/hari"),
        Car("Toyota", "Camry", "Rp 1.200.000/hari"),
        Car("Honda", "HR-V Prestige", "Rp 750.000/hari"),
        Car("Toyota", "Innova Reborn", "Rp 800.000/hari"),
        Car("Toyota", "Camry", "Rp 1.250.000/hari")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)        // pakai layout lama kamu

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CarAdapter(carList)
        recyclerView.setHasFixedSize(true)
    }

    // Extension biar toast lebih gampang
    private fun toast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}