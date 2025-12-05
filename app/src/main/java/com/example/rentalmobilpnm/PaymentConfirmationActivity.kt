package com.example.rentalmobilpnm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rentalmobilpnm.databinding.ActivityPaymentConfirmationBinding

class PaymentConfirmationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPaymentConfirmationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentConfirmationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil data dari Intent
        val carName = intent.getStringExtra("car_name")
        val price = intent.getStringExtra("price")
        val startDate = intent.getStringExtra("start_date")
        val endDate = intent.getStringExtra("end_date")
        val total = intent.getStringExtra("total")

        // Tampilkan
        binding.txtCarName.text = "Mobil: $carName"
        binding.txtPrice.text = "Harga per hari: $price"
        binding.txtDuration.text = "Tanggal: $startDate → $endDate"
        binding.txtTotalPayment.text = "Total Pembayaran: $total"

        binding.btnConfirm.setOnClickListener {
            finish() // atau arahkan ke halaman lain
        }
    }
}
