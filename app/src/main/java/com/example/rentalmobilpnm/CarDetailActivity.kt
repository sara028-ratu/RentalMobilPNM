package com.example.rentcar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rentcar.databinding.ActivityCarDetailBinding
import com.squareup.picasso.Picasso

class CarDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCarDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // === Ambil data dari Intent ===
        val carName = intent.getStringExtra("car_name")
        val carYear = intent.getStringExtra("car_year")
        val carPrice = intent.getStringExtra("car_price")
        val carImage = intent.getStringExtra("car_image")
        val carSeats = intent.getStringExtra("car_seat")
        val carFuel = intent.getStringExtra("car_fuel")
        val carTrans = intent.getStringExtra("car_transmission")
        val carDesc = intent.getStringExtra("car_desc")

        // === Set ke tampilan ===
        binding.tvCarName.text = carName
        binding.tvCarYear.text = carYear
        binding.tvCarPrice.text = carPrice
        binding.tvCarSeats.text = carSeats
        binding.tvCarFuel.text = carFuel
        binding.tvCarTrans.text = carTrans
        binding.tvCarDesc.text = carDesc

        // === Load image mobil ===
        Picasso.get()
            .load(carImage)
            .into(binding.imgCar)

        // === Tombol Back ===
        binding.btnBack.setOnClickListener {
            finish()
        }

        // === Tombol Rent This Car ===
        binding.btnRentCar.setOnClickListener {
            // Arahkan ke halaman transaksi atau form lain
            // Bisa diganti sesuai kebutuhan
        }
    }
}
