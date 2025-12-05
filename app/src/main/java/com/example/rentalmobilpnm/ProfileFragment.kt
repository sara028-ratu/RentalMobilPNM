package com.example.rentalmobilpnm

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Kenalkan TextView Nama & Email dari XML
        val tvName = view.findViewById<TextView>(R.id.tvUserName) // Pastikan ID di XML sudah ada
        val tvEmail = view.findViewById<TextView>(R.id.tvUserEmail)

        // 2. Buka "Buku Catatan" yang sama (UserSession)
        val sharedPref = requireActivity().getSharedPreferences("UserSession", Context.MODE_PRIVATE)

        // 3. Ambil data (Kalau kosong, defaultnya "Tamu")
        val namaDisimpan = sharedPref.getString("nama_user", "Tamu")

        // 4. Tampilkan ke layar
        tvName.text = namaDisimpan
        tvEmail.text = "$namaDisimpan@student.poltek-madiun.ac.id" // Contoh format email otomatis

        // 1. Definisikan Tombol Edit
        val btnEdit = view.findViewById<LinearLayout>(R.id.btnEditProfile)

        // 2. Logic saat diklik (PINDAH HALAMAN AMAN)
        btnEdit.setOnClickListener {

            // A. Panggil Fragment Manager
            val transaction = parentFragmentManager.beginTransaction()

            // B. Ganti layar saat ini dengan EditProfileFragment
            // PENTING: Pastikan R.id.fragment_container adalah ID yang ada di MainActivity-mu
            transaction.replace(R.id.fragment_container, EditProfileFragment())

            // C. Masukkan ke BackStack (Supaya bisa di-Back)
            transaction.addToBackStack(null)

            // D. Jalankan
            transaction.commit()
        }

        // Logic Logout (Opsional)
        val btnLogout = view.findViewById<LinearLayout>(R.id.btnLogout)
        btnLogout.setOnClickListener {
            Toast.makeText(context, "Logout Berhasil", Toast.LENGTH_SHORT).show()
        }
    }
}