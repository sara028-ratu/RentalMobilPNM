package com.example.rentalmobilpnm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HelpAdapter(private val listHelp: ArrayList<HelpModel>) : RecyclerView.Adapter<HelpAdapter.ViewHolder>() {

    // 1. ViewHolder: Mengenalkan komponen yang ada di layout item_help_step
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNumber: TextView = itemView.findViewById(R.id.tvSetNumber)
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvDesc: TextView = itemView.findViewById(R.id.tvDesc)
    }

    // 2. Membuat tampilan awal (inflate layout)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_help_step, parent, false)
        return ViewHolder(view)
    }

    // 3. Mengisi data ke tampilan (Looping terjadi disini)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listHelp[position]
        holder.tvNumber.text = data.number
        holder.tvTitle.text = data.title
        holder.tvDesc.text = data.desc
    }

    // 4. Menghitung jumlah data
    override fun getItemCount(): Int {
        return listHelp.size
    }
}