package com.example.rentalmobilpnm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HelpFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Sambungkan ke layout XML
        return inflater.inflate(R.layout.fragment_help, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Siapkan Data (Sesuai Gambar Desain)
        val dataList = arrayListOf<HelpModel>()
        dataList.add(HelpModel("1", "Browse Cars", "Open the Car List page and select a car you want to rent from our available fleet."))
        dataList.add(HelpModel("2", "Fill Rental Details", "Choose rental date, duration, driver option, pickup/return address, and any special notes."))
        dataList.add(HelpModel("3", "Review Order", "Check summary of charges including rental price, service fee, and total amount."))
        dataList.add(HelpModel("4", "Confirm and Pay", "Confirm your rental details and complete the secure payment process."))
        dataList.add(HelpModel("5", "Receive Car", "Car is delivered or picked up according to your selected details and schedule."))
        dataList.add(HelpModel("6", "Return the Car", "Return the car based on the agreed location and schedule. Complete your rental!"))

        // 2. Panggil RecyclerView dari XML
        val rvHelp = view.findViewById<RecyclerView>(R.id.rvHelp)

        // 3. Pasang Adapter
        val adapter = HelpAdapter(dataList)
        rvHelp.layoutManager = LinearLayoutManager(context)
        rvHelp.adapter = adapter
    }
}