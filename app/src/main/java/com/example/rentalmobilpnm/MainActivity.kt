package com.example.rentalmobilpnm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val carList = listOf(
        Car("Honda", "Civic Turbo", "Rp 650.000/hari", R.drawable.civic_turbo),
        Car("Toyota", "Fortuner VRZ", "Rp 900.000/hari", R.drawable.fortuner_vrz),
        Car("Toyota", "Camry", "Rp 1.200.000/hari", R.drawable.camry),
        Car("Honda", "HR-V Prestige", "Rp 750.000/hari", R.drawable.hrv_prestige),
        Car("Toyota", "Innova Reborn", "Rp 800.000/hari", R.drawable.innova_reborn),
        Car("Toyota", "Camry", "Rp 1.250.000/hari", R.drawable.camry)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Cek login
        if (!isLoggedIn()) {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
            return
        }

        // Inisialisasi RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = CarAdapter(carList)

        // Bottom Navigation
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Set halaman awal
        loadFragment(HomeFragment())

        // Navigasi menu
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> loadFragment(HomeFragment())
                R.id.nav_myorders -> loadFragment(MyOrdersFragment())
                R.id.nav_help -> loadFragment(HelpFragment())
                R.id.nav_profile -> loadFragment(ProfileFragment())
            }
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    private fun isLoggedIn(): Boolean {
        return intent.getBooleanExtra("LOGGED_IN", false)
    }
}
