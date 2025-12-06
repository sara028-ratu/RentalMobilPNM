package com.example.rentalmobilpnm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // CEK APAKAH SUDAH LOGIN?
        val sharedPref = getSharedPreferences("UserSession", MODE_PRIVATE)
        // Kalau di dalam buku catatan sudah ada "email_user", berarti user belum logout
        if (sharedPref.contains("email_user")) {
            // Langsung lempar ke MainActivity (Lewati Login)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
            return // Berhenti di sini, jangan lanjut tampilkan layout login
        }

        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        // Edge to Edge layout padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Ambil ID dari layout
        val edtUsername = findViewById<EditText>(R.id.edtEmail)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        // Logika tombol Login
        btnLogin.setOnClickListener {
            val username = edtUsername.text.toString().trim()
            val password = edtPassword.text.toString().trim()

            // 1. Validasi: Cuma cek apakah kosong atau tidak
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Username dan Password harus diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // --- BAGIAN LAMA DIHAPUS ---
            // if (username == "admin" && password == "123") { ... }  <-- INI HAPUS

            // --- GANTI DENGAN LOGIC BARU (LANGSUNG TERIMA) ---

            // 2. Simpan Nama User (Agar muncul di halaman Profile nanti)
            val sharedPref = getSharedPreferences("UserSession", MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putString("email_user", username) // Simpan apapun yang diketik user
            editor.apply()

            // 3. Beri sapaan dan Pindah Halaman
            Toast.makeText(this, "Selamat Datang, $username!", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
