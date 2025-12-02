package com.example.rentalmobilpnm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

data class Car(
    val brand: String,
    val model: String,
    val price: String
)

class MainActivity : AppCompatActivity() {

    private val carList = listOf(
        Car("Honda", "Civic Turbo", "Rp 650.000/hari"),
        Car("Toyota", "Fortuner VRZ", "Rp 900.000/hari"),
        Car("Toyota", "Camry", "Rp 1.200.000/hari"),
        Car("Honda", "HR-V Prestige", "Rp 750.000/hari"),
        Car("Toyota", "Innova Reborn", "Rp 800.000/hari"),
        Car("Toyota", "Camry", "Rp 1.250.000/hari")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // CEK LOGIN – kalau belum login, lempar ke LoginActivity
        if (!isLoggedIn()) {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
            return
        }

        // Kalau sudah login, lanjut tampilkan daftar mobil
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        // Dibuat Irfan
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Set halaman awal (Home) saat aplikasi dibuka
        loadFragment(HomeFragment())

        // Logic saat menu diklik
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> loadFragment(HomeFragment())
                R.id.nav_myorders -> loadFragment(MyOrdersFragment())
                R.id.nav_help -> loadFragment(HelpFragment()) // Ini tugasmu tadi
                R.id.nav_profile -> loadFragment(ProfileFragment())
            }
            true
        }
    }

    // Fungsi untuk menukar fragment
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    // Fungsi cek status login (nanti bisa diganti SharedPreferences)
    private fun isLoggedIn(): Boolean {
        // Sekarang pakai cara paling gampang: cek apakah datang dari LoginActivity
        return intent.getBooleanExtra("LOGGED_IN", false)
    }
}