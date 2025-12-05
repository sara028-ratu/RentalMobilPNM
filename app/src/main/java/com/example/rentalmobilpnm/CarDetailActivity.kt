package com.example.rentalmobilpnm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rentalmobilpnm.databinding.ActivityCarDetailBinding

class CarDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCarDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil data dari Intent
        val brand = intent.getStringExtra("brand") ?: "-"
        val model = intent.getStringExtra("model") ?: "-"
        val seats = intent.getStringExtra("seats") ?: "-"
        val transmission = intent.getStringExtra("transmission") ?: "-"
        val fuel = intent.getStringExtra("fuel") ?: "-"
        val year = intent.getIntExtra("year", 0)
        val price = intent.getIntExtra("price", 0)
        val image = intent.getIntExtra("image", 0)
        val description = intent.getStringExtra("description") ?: "-"
        val features = intent.getStringExtra("features") ?: "-"

        // Set tampilan
        binding.txtCarName.text = "$brand $model"
        binding.txtSeats.text = "$seats"
        binding.txtTransmission.text = transmission
        binding.txtFuel.text = fuel
        binding.txtYear.text = "$year"
        binding.txtPrice.text = "Rp $price / hari"
        binding.txtDescription.text = description
        binding.txtFeatures.text = features

        if (image != 0) binding.imgCar.setImageResource(image)

        // Tombol untuk buka form penyewaan
        binding.btnRent.setOnClickListener {
            val intent = Intent(this, RentalFormActivity::class.java)
            intent.putExtra("car_name", "$brand $model")
            intent.putExtra("car_price", price)
            startActivity(intent)
        }
    }
}
