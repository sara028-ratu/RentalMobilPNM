package com.example.rentalmobilpnm

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MyOrderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_orders, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvOrder = view.findViewById<RecyclerView>(R.id.rvOrder)

        // 1. BACA DATA (Gunakan nama "MyOrderHistory" yang sama dgn langkah 4)
        val sharedPref = requireActivity().getSharedPreferences("MyOrderHistory", Context.MODE_PRIVATE)
        val adaHistory = sharedPref.getBoolean("has_history", false)

        // Gunakan MyOrderModel
        val dataList = arrayListOf<MyOrderModel>()

        if (adaHistory) {
            val mobil = sharedPref.getString("history_car", "-") ?: "-"
            val tgl = sharedPref.getString("history_date", "-") ?: "-"
            val harga = sharedPref.getString("history_price", "-") ?: "-"
            val status = sharedPref.getString("history_status", "Aktif") ?: "Aktif"

            dataList.add(MyOrderModel(mobil, tgl, harga, status))
        }

        // 2. PASANG ADAPTER (Gunakan MyOrderAdapter)
        val adapter = MyOrderAdapter(dataList)
        rvOrder.layoutManager = LinearLayoutManager(context)
        rvOrder.adapter = adapter
    }
}