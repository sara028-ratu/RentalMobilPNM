package com.example.rentalmobilpnm

import android.content.Context
import android.content.Intent
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

        // --- BAGIAN 1: HEADER (Data Login) ---
        val tvUserName = view.findViewById<TextView>(R.id.tvUserName)
        val tvUserEmail = view.findViewById<TextView>(R.id.tvUserEmail)

        val sharedPref = requireActivity().getSharedPreferences("UserSession", Context.MODE_PRIVATE)

        // Ambil Email dari Login
        val fullEmail = sharedPref.getString("email_user", "Tamu") ?: "Tamu"

        // Logic potong email jadi username
        val username = fullEmail.substringBefore("@").replaceFirstChar { it.uppercase() }

        // Tampilkan di Header Biru
        tvUserName.text = username
        tvUserEmail.text = fullEmail


        // --- BAGIAN 2: BODY (Biodata dari Edit Profile) ---
        val tvName = view.findViewById<TextView>(R.id.tvShowName)
        val tvPhone = view.findViewById<TextView>(R.id.tvShowPhone)
        val tvAddress = view.findViewById<TextView>(R.id.tvShowAddress)

        // Ambil Biodata (Default "-")
        val namaLengkap = sharedPref.getString("nama_lengkap", "-") ?: "-"
        val nomorHP = sharedPref.getString("nomor_telepon", "-") ?: "-"
        val alamatUser = sharedPref.getString("alamat_user", "-") ?: "-"

        // Tampilkan di Kotak Putih
        tvName.text = namaLengkap
        tvPhone.text = nomorHP
        tvAddress.text = alamatUser


        // --- BAGIAN 3: NAVIGASI TOMBOL ---

        // Tombol Ubah Biodata
        val btnEdit = view.findViewById<LinearLayout>(R.id.btnEditProfile)
        btnEdit.setOnClickListener {
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, EditProfileFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        // Tombol Logout
        val btnLogout = view.findViewById<LinearLayout>(R.id.btnLogout)
        btnLogout.setOnClickListener {
            // 1. HAPUS DATA DARI MEMORI (Buku Catatan)
            // Supaya saat login lagi nanti, datanya bersih
            val editor = sharedPref.edit()
            editor.clear()
            editor.apply()

            // 2. TAMPILKAN PESAN
            Toast.makeText(context, "Logout Berhasil", Toast.LENGTH_SHORT).show()

            // 3. PINDAH KE HALAMAN LOGIN
            // Pastikan nama file loginmu 'LoginActivity'
            val intent = Intent(requireActivity(), LoginActivity::class.java)

            // PENTING: Tambahkan bendera (flags) ini
            // Gunanya untuk "menghancurkan" semua halaman sebelumnya (MainActivity, dll)
            // Jadi kalau user tekan tombol Back di HP, aplikasi akan keluar, bukan balik ke Profil
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            startActivity(intent)
        }
    }
}