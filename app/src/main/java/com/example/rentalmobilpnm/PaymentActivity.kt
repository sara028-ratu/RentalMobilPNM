package com.example.rentalmobilpnm

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class PaymentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        val carName = intent.getStringExtra("car_name")
        val total = intent.getStringExtra("total")

        val txtTotal = findViewById<TextView>(R.id.txtTotalPay)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroupPayment)
        val btnPay = findViewById<Button>(R.id.btnPayNow)

        txtTotal.text = "Total Pembayaran: $total"

        btnPay.setOnClickListener {
            val selectedId = radioGroup.checkedRadioButtonId

            if (selectedId == -1) {
                Toast.makeText(this, "Pilih metode pembayaran terlebih dahulu", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val method = findViewById<RadioButton>(selectedId).text.toString()

            // Arahkan ke halaman konfirmasi
            val intent = Intent(this, PaymentConfirmationActivity::class.java)
            intent.putExtra("car_name", carName)
            intent.putExtra("total", total)
            intent.putExtra("payment_method", method)
            startActivity(intent)
        }
    }
}
