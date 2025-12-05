package com.example.rentalmobilpnm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rentalmobilpnm.databinding.ActivityOrderSuccessBinding

class OrderSuccessActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOrderSuccessBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderSuccessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Terima data dari RentalFormActivity
        val name = intent.getStringExtra("customer_name") ?: "-"
        val phone = intent.getStringExtra("phone") ?: "-"
        val car = intent.getStringExtra("car_name") ?: "-"
        val total = intent.getIntExtra("total", 0)
        val start = intent.getStringExtra("start") ?: "-"
        val end = intent.getStringExtra("end") ?: "-"
        val address = intent.getStringExtra("address") ?: "-"
        val driver = intent.getStringExtra("driver") ?: "-"
        val delivery = intent.getStringExtra("delivery") ?: "-"
        val pickup = intent.getStringExtra("pickup") ?: "-"
        val notes = intent.getStringExtra("notes") ?: "-"

        // Tampilkan ringkasan
        binding.txtSummary.text =
            """
            Pemesanan Berhasil!

            Nama: $name
            Telepon: $phone
            Alamat: $address

            Mobil: $car
            Driver: $driver

            Alamat Pengantaran: $delivery
            Alamat Penjemputan: $pickup

            Catatan:
            $notes

            Mulai Sewa: $start
            Selesai Sewa: $end

            Total Pembayaran: Rp $total
            """.trimIndent()

        // Tombol kembali
        binding.btnBackHome.setOnClickListener { finish() }
    }
}
