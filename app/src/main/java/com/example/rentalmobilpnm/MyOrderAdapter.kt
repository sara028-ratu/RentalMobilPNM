package com.example.rentalmobilpnm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyOrderAdapter(private val listMyOrder: List<MyOrderModel>) :
    RecyclerView.Adapter<MyOrderAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Pastikan ID ini sesuai dengan item_my_order.xml tadi
        val tvName: TextView = itemView.findViewById(R.id.tvMyCarName)
        val tvDate: TextView = itemView.findViewById(R.id.tvMyDate)
        val tvPrice: TextView = itemView.findViewById(R.id.tvMyPrice)
        val tvStatus: TextView = itemView.findViewById(R.id.tvMyStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Panggil layout item_my_order
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_my_order, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listMyOrder[position]
        holder.tvName.text = item.carName
        holder.tvDate.text = item.date
        holder.tvPrice.text = item.price
        holder.tvStatus.text = item.status
    }

    override fun getItemCount(): Int {
        return listMyOrder.size
    }
}