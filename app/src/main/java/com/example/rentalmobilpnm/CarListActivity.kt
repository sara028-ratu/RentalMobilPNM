package com.example.rentalmobilpnm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rentalmobilpnm.databinding.ActivityCarListBinding

class CarListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCarListBinding
    private lateinit var adapter: CarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val carList = listOf(
            Car("Toyota", "Avanza", "Rp 350.000/hari", R.drawable.sample_car),
            Car("Honda", "Brio", "Rp 250.000/hari", R.drawable.sample_car),
            Car("Daihatsu", "Xenia", "Rp 330.000/hari", R.drawable.sample_car)
        )

        adapter = CarAdapter(carList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }
}
