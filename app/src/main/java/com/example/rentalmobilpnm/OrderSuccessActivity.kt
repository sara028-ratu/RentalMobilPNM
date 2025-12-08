package com.example.rentalmobilpnm

import android.content.Context // TAMBAHAN: Untuk akses penyimpanan
import android.content.Intent // TAMBAHAN: Untuk pindah halaman
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rentalmobilpnm.databinding.ActivityOrderSuccessBinding

class OrderSuccessActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOrderSuccessBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderSuccessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Terima data dari RentalFormActivity
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


        // --- [BAGIAN PENTING] TAMBAHAN DARI KAMU (SIMPAN DATA) ---
        // Kita simpan data ini ke "MyOrderHistory" agar bisa dibaca di MyOrderFragment
        val sharedPref = getSharedPreferences("MyOrderHistory", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        editor.putString("history_car", car)           // Simpan Nama Mobil
        editor.putString("history_date", "$start s/d $end") // Simpan Tanggal Gabungan
        editor.putString("history_price", "Rp $total") // Simpan Harga
        editor.putString("history_status", "Aktif")    // Simpan Status
        editor.putBoolean("has_history", true)         // Penanda bahwa ada pesanan

        editor.apply() // Simpan Permanen!
        // ---------------------------------------------------------


        // 2. Tampilkan ringkasan (Ini kode asli temanmu)
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

        // 3. Tombol kembali (SAYA UBAH SEDIKIT)
        binding.btnBackHome.setOnClickListener {
            // Kita arahkan ke MainActivity (Home)
            val intent = Intent(this, MainActivity::class.java)
            // Bendera ini supaya aplikasi tidak menumpuk halaman (bersih)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}