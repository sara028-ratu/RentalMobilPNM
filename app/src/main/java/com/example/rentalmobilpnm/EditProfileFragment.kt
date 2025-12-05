package com.example.rentalmobilpnm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class EditProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Hubungkan dengan layout XML Edit Profile yang tadi kita buat
        return inflater.inflate(R.layout.fragment_edit_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Kenalkan Komponen Input & Tombol
        val etName = view.findViewById<EditText>(R.id.etEditName)
        val etPhone = view.findViewById<EditText>(R.id.etEditPhone)
        val etAddress = view.findViewById<EditText>(R.id.etEditAddress)
        val btnSave = view.findViewById<Button>(R.id.btnSaveChanges)

        // 2. Aksi saat tombol Save diklik
        btnSave.setOnClickListener {
            // Ambil teks yang diketik user
            val nama = etName.text.toString()
            val hp = etPhone.text.toString()
            val alamat = etAddress.text.toString()

            // Validasi sederhana (Cek kalau kosong)
            if (nama.isEmpty() || hp.isEmpty() || alamat.isEmpty()) {
                Toast.makeText(context, "Harap isi semua data!", Toast.LENGTH_SHORT).show()
            } else {
                // Simulasi Simpan Data
                Toast.makeText(context, "Data $nama berhasil disimpan!", Toast.LENGTH_SHORT).show()

                // Kembali ke halaman Profile secara otomatis setelah simpan
                parentFragmentManager.popBackStack()
            }
        }
    }
}