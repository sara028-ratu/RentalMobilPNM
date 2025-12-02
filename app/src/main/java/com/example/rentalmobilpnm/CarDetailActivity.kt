package com.example.rentalmobilpnm

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rentalmobilpnm.databinding.ActivityCarDetailBinding
import java.util.Calendar

class CarDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCarDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil data dari Intent (nama key sesuai yang dikirim dari Adapter)
        val brandModel = intent.getStringExtra("brand") ?: intent.getStringExtra("car_name")
        val model = intent.getStringExtra("model")
        val price = intent.getStringExtra("price") ?: intent.getStringExtra("car_price")
        val imageRes = intent.getIntExtra("image", intent.getIntExtra("car_image", 0))

        // Set ke tampilan (sesuai id di activity_car_detail.xml)
        // XML kamu menggunakan: txtCarName, txtCarYear, txtTransmission, txtCapacity, txtPrice, imgCar, btnBack, etStartDate, etEndDate, btnRent
        binding.txtCarName.text = brandModel ?: "Nama Mobil"
        // Jika kamu mengirim tahun/transmisi/kapasitas lewat intent, ambil dan set juga:
        val year = intent.getStringExtra("car_year")
        val trans = intent.getStringExtra("car_trans")
        val capacity = intent.getStringExtra("car_capacity")

        if (!year.isNullOrEmpty()) binding.txtCarYear.text = "Tahun: $year"
        if (!trans.isNullOrEmpty()) binding.txtTransmission.text = "Transmisi: $trans"
        if (!capacity.isNullOrEmpty()) binding.txtCapacity.text = capacity

        binding.txtPrice.text = price ?: "Harga: -"

        if (imageRes != 0) {
            binding.imgCar.setImageResource(imageRes)
        }

        // tombol kembali
        binding.btnBack.setOnClickListener { finish() }

        // date pickers untuk EditText yang non-focusable
        binding.etStartDate.setOnClickListener {
            showDatePicker { dateStr -> binding.etStartDate.setText(dateStr) }
        }

        binding.etEndDate.setOnClickListener {
            showDatePicker { dateStr -> binding.etEndDate.setText(dateStr) }
        }

        // tombol sewa (lanjut ke payment nanti)
        binding.btnRent.setOnClickListener {
            // TODO: implementasi lanjut ke Payment / Confirmation
        }
    }

    private fun showDatePicker(onSelect: (String) -> Unit) {
        val c = Calendar.getInstance()
        val y = c.get(Calendar.YEAR)
        val m = c.get(Calendar.MONTH)
        val d = c.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this, { _, year, month, dayOfMonth ->
            onSelect(String.format("%02d-%02d-%04d", dayOfMonth, month + 1, year))
        }, y, m, d).show()
    }
}
