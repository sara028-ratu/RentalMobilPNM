package com.example.rentalmobilpnm

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rentalmobilpnm.databinding.ActivityRentalFormBinding
import java.util.*

class RentalFormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRentalFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRentalFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TERIMA DATA DARI CARDETAIL
        val carName = intent.getStringExtra("car_name") ?: "Mobil"
        val carPrice = intent.getIntExtra("car_price", 0)

        // TAMPILKAN KE UI
        binding.txtCarName.text = carName
        binding.txtPrice.text = "Harga / hari: Rp $carPrice"

        // SPINNER DRIVER
        val driverOptions = arrayOf("Tidak", "Ya")
        binding.spDriver.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, driverOptions)

        // DATE PICKER
        binding.etStartDate.setOnClickListener {
            showDatePicker { binding.etStartDate.setText(it) }
        }
        binding.etEndDate.setOnClickListener {
            showDatePicker { binding.etEndDate.setText(it) }
        }

        // HITUNG TOTAL
        binding.btnCalculate.setOnClickListener {
            val days = binding.etDays.text.toString().trim().toIntOrNull()

            if (days == null || days <= 0) {
                Toast.makeText(this, "Masukkan jumlah hari!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val total = carPrice * days
            binding.txtTotal.text = "Total: Rp $total"
        }

        // KONFIRMASI PESANAN
        binding.btnConfirm.setOnClickListener {

            val name = binding.etName.text.toString().trim()
            val phone = binding.etPhone.text.toString().trim()
            val address = binding.etAddress.text.toString().trim()

            val driver = binding.spDriver.selectedItem.toString()
            val delivery = binding.etDeliveryAddress.text.toString().trim()
            val pickup = binding.etPickupAddress.text.toString().trim()
            val notes = binding.etNotes.text.toString().trim()

            val start = binding.etStartDate.text.toString().trim()
            val end = binding.etEndDate.text.toString().trim()
            val days = binding.etDays.text.toString().trim().toIntOrNull()

            if (name.isEmpty() || phone.isEmpty() || address.isEmpty() ||
                start.isEmpty() || end.isEmpty() || days == null
            ) {
                Toast.makeText(this, "Lengkapi semua data!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (driver == "Ya" && delivery.isEmpty()) {
                Toast.makeText(this, "Alamat pengiriman wajib jika pakai driver!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val total = carPrice * days

            val intent = Intent(this, OrderSuccessActivity::class.java)
            intent.putExtra("customer_name", name)
            intent.putExtra("phone", phone)
            intent.putExtra("car_name", carName)
            intent.putExtra("total", total)
            intent.putExtra("start", start)
            intent.putExtra("end", end)
            intent.putExtra("address", address)
            intent.putExtra("driver", driver)
            intent.putExtra("delivery", delivery)
            intent.putExtra("pickup", pickup)
            intent.putExtra("notes", notes)

            startActivity(intent)
        }
    }

    private fun showDatePicker(onSelect: (String) -> Unit) {
        val c = Calendar.getInstance()
        DatePickerDialog(
            this,
            { _, y, m, d ->
                onSelect(String.format("%02d-%02d-%04d", d, m + 1, y))
            },
            c.get(Calendar.YEAR),
            c.get(Calendar.MONTH),
            c.get(Calendar.DAY_OF_MONTH)
        ).show()
    }
}
