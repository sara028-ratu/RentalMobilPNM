package com.example.rentalmobilpnm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    private val carList = listOf(
        Car("Honda", "Civic Turbo", "Rp 650.000/hari", R.drawable.civic_turbo),
        Car("Toyota", "Fortuner VRZ", "Rp 900.000/hari", R.drawable.fortuner_vrz),
        Car("Toyota", "Camry", "Rp 1.200.000/hari", R.drawable.camry),
        Car("Honda", "HR-V Prestige", "Rp 750.000/hari", R.drawable.hrv_prestige),
        Car("Toyota", "Innova Reborn", "Rp 800.000/hari", R.drawable.innova_reborn),
        Car("Toyota", "Camry", "Rp 1.250.000/hari", R.drawable.camry)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Ambil RecyclerView dari fragment_home.xml
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewHome)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = CarAdapter(carList)

        return view
    }
}
