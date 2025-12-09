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

        // HEADER (Data Login) ---
        val tvUserName = view.findViewById<TextView>(R.id.tvUserName)
        val tvUserEmail = view.findViewById<TextView>(R.id.tvUserEmail)

        val sharedPref = requireActivity().getSharedPreferences("UserSession", Context.MODE_PRIVATE)

        // Mengambil Email dari Login
        val fullEmail = sharedPref.getString("email_user", "Tamu") ?: "Tamu"

        // Logic potong email jadi username
        val username = fullEmail.substringBefore("@").replaceFirstChar { it.uppercase() }

        // menampilan di Header Biru
        tvUserName.text = username
        tvUserEmail.text = fullEmail


        //BODY (Biodata dari Edit Profile) ---
        val tvName = view.findViewById<TextView>(R.id.tvShowName)
        val tvPhone = view.findViewById<TextView>(R.id.tvShowPhone)
        val tvAddress = view.findViewById<TextView>(R.id.tvShowAddress)

        // menagmbil Biodata (Default "-")
        val namaLengkap = sharedPref.getString("nama_lengkap", "-") ?: "-"
        val nomorHP = sharedPref.getString("nomor_telepon", "-") ?: "-"
        val alamatUser = sharedPref.getString("alamat_user", "-") ?: "-"

        // menampilakan di Kotak Putih
        tvName.text = namaLengkap
        tvPhone.text = nomorHP
        tvAddress.text = alamatUser


        // NAVIGASI TOMBOL ---

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

            // menghapus data dari memeori, Supaya saat login lagi nanti, datanya bersih
            val editor = sharedPref.edit()
            editor.clear()
            editor.apply()

            // menampilkann PESAN
            Toast.makeText(context, "Logout Berhasil", Toast.LENGTH_SHORT).show()

            // PINDAH KE HALAMAN LOGIN
            // Pastikan nama file loginmu 'LoginActivity'
            val intent = Intent(requireActivity(), LoginActivity::class.java)

            // bendera (flags) ini untuk menutup semua halaman sebelumnya
            // Jadi kalau user tekan tombol Back di HP, aplikasi akan keluar, bukan balik ke Profil
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            startActivity(intent)
        }
    }
}