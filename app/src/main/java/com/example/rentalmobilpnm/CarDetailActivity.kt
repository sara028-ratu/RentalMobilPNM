package com.example.rentalmobilpnm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rentalmobilpnm.databinding.ActivityCarDetailBinding
import com.squareup.picasso.Picasso

class CarDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCarDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val carName = intent.getStringExtra("car_name")
        val carYear = intent.getStringExtra("car_year")
        val carPrice = intent.getStringExtra("car_price")
        val carImage = intent.getStringExtra("car_image")
        val carSeats = intent.getStringExtra("car_seat")
        val carFuel = intent.getStringExtra("car_fuel")
        val carTrans = intent.getStringExtra("car_transmission")
        val carDesc = intent.getStringExtra("car_desc")

        binding.tvCarName.text = carName
        binding.tvCarYear.text = carYear
        binding.tvCarPrice.text = carPrice
        binding.tvCarSeats.text = carSeats
        binding.tvCarFuel.text = carFuel
        binding.tvCarTrans.text = carTrans
        binding.tvCarDesc.text = carDesc

        Picasso.get()
            .load(carImage)
            .into(binding.imgCar)

        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.btnRentCar.setOnClickListener {
            // TODO: lanjutkan ke transaksi
        }
    }
}
