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
        CarModel(
            brand = "Honda",
            model = "Civic Turbo",
            seats = "5 Kursi",
            transmission = "Automatic",
            fuel = "Bensin",
            year = 2022,
            price = 650000,
            image = R.drawable.civic_turbo,
            description = "Sedan sport premium dengan mesin turbo dan kenyamanan maksimal.",
            features = "Turbo Engine, ABS, Airbag, Bluetooth"
        ),

        CarModel(
            brand = "Toyota",
            model = "Fortuner VRZ",
            seats = "7 Kursi",
            transmission = "Automatic",
            fuel = "Diesel",
            year = 2021,
            price = 900000,
            image = R.drawable.fortuner_vrz,
            description = "SUV premium bertenaga kuat untuk segala medan.",
            features = "Diesel Engine, Cruise Control, ABS, Airbag"
        ),

        CarModel(
            brand = "Toyota",
            model = "Camry",
            seats = "5 Kursi",
            transmission = "Automatic",
            fuel = "Bensin",
            year = 2022,
            price = 1200000,
            image = R.drawable.camry,
            description = "Sedan mewah dengan kenyamanan tingkat tinggi.",
            features = "Sunroof, Premium Interior, ABS, Airbag"
        ),

        CarModel(
            brand = "Honda",
            model = "HR-V Prestige",
            seats = "5 Kursi",
            transmission = "Automatic",
            fuel = "Bensin",
            year = 2021,
            price = 750000,
            image = R.drawable.hrv_prestige,
            description = "SUV modern yang cocok untuk keluarga dan perjalanan jauh.",
            features = "Keyless, Electric Seat, ABS, Airbag"
        ),

        CarModel(
            brand = "Toyota",
            model = "Innova Reborn",
            seats = "7 Kursi",
            transmission = "Manual",
            fuel = "Diesel",
            year = 2020,
            price = 800000,
            image = R.drawable.innova_reborn,
            description = "MPV terbaik untuk keluarga besar, nyaman dan bertenaga.",
            features = "Diesel Engine, Rear AC, ABS, Airbag"
        ),

        CarModel(
            brand = "Toyota",
            model = "Camry",
            seats = "5 Kursi",
            transmission = "Automatic",
            fuel = "Bensin",
            year = 2023,
            price = 1250000,
            image = R.drawable.camry,
            description = "Versi terbaru Camry dengan fitur-fitur premium.",
            features = "Sunroof, ABS, Airbag, Premium Sound"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Setup RecyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewHome)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = CarAdapter(carList)

        return view
    }
}
