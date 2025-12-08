package com.example.rentalmobilpnm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HelpFragment: Fragment() {
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

        // 1. Pilih Mobil
        dataList.add(HelpModel("1", "Pilih Mobil", "Buka halaman Daftar Mobil dan pilih mobil yang ingin Anda sewa dari armada kami."))

        // 2. Isi Detail
        dataList.add(HelpModel("2", "Isi Detail Sewa", "Pilih tanggal sewa, durasi, opsi sopir, alamat antar/jemput, dan catatan khusus."))

        // 3. Cek Pesanan
        dataList.add(HelpModel("3", "Cek Pesanan", "Periksa rincian biaya termasuk harga sewa, biaya layanan, dan total tagihan."))

        // 4. Bayar
        dataList.add(HelpModel("4", "Konfirmasi & Bayar", "Konfirmasi detail sewa Anda dan selesaikan proses pembayaran yang aman."))

        // 5. Terima Mobil
        dataList.add(HelpModel("5", "Terima Mobil", "Mobil akan diantar atau diambil sesuai dengan detail dan jadwal yang Anda pilih."))

        // 6. Kembalikan
        dataList.add(HelpModel("6", "Kembalikan Mobil", "Kembalikan mobil sesuai lokasi dan jadwal yang disepakati. Sewa selesai!"))

        // 2. Panggil RecyclerView dari XML
        val rvHelp = view.findViewById<RecyclerView>(R.id.rvHelp)

        // 3. Pasang Adapter
        val adapter = HelpAdapter(dataList)
        rvHelp.layoutManager = LinearLayoutManager(context)
        rvHelp.adapter = adapter
    }
}