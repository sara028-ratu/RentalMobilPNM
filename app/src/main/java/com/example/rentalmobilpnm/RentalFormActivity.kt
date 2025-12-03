package com.example.rentalmobilpnm

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class RentalFormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rental_form)

        // Semua ID dari XML
        val etStartDate = findViewById<EditText>(R.id.etStartDate)
        val etDuration = findViewById<EditText>(R.id.etDuration)
        val switchDriver = findViewById<Switch>(R.id.switchDriver)
        val btnConfirmPay = findViewById<Button>(R.id.btnConfirmPay)
        val btnChangeCar = findViewById<TextView>(R.id.btnChangeCar)

        // TOMBOL KALENDER
        etStartDate.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(this, { _, y, m, d ->
                etStartDate.setText("$d/${m+1}/$y")
            }, year, month, day)

            datePicker.show()
        }


        // SWITCH DRIVER
        switchDriver.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Dengan Driver dipilih", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Tanpa Driver", Toast.LENGTH_SHORT).show()
            }
        }


        // TOMBOL UBAH MOBIL
        btnChangeCar.setOnClickListener {
            Toast.makeText(this, "Pilih mobil lain", Toast.LENGTH_SHORT).show()
            // nanti bisa buka activity daftar mobil
        }


        // TOMBOL CONFIRM & PAY
        btnConfirmPay.setOnClickListener {
            val date = etStartDate.text.toString()
            val duration = etDuration.text.toString()
            val driver = if (switchDriver.isChecked) "Ya" else "Tidak"

            Toast.makeText(
                this,
                "Tanggal: $date\nDurasi: $duration hari\nDriver: $driver",
                Toast.LENGTH_LONG
            ).show()

            // Nanti bisa diarahkan ke halaman pembayaran
        }
    }
}
