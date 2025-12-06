package com.example.rentalmobilpnm

import android.content.Context
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
        return inflater.inflate(R.layout.fragment_edit_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Kenalkan Komponen Input
        val etName = view.findViewById<EditText>(R.id.etEditName)
        val etPhone = view.findViewById<EditText>(R.id.etEditPhone)
        val etAddress = view.findViewById<EditText>(R.id.etEditAddress)
        val btnSave = view.findViewById<Button>(R.id.btnSaveChanges)

        // 2. Logic Simpan Data
        btnSave.setOnClickListener {
            val nama = etName.text.toString()
            val hp = etPhone.text.toString()
            val alamat = etAddress.text.toString()

            if (nama.isEmpty() || hp.isEmpty() || alamat.isEmpty()) {
                Toast.makeText(context, "Harap isi semua data!", Toast.LENGTH_SHORT).show()
            } else {
                // --- PROSES SIMPAN DATA KE MEMORI HP ---
                val sharedPref = requireActivity().getSharedPreferences("UserSession", Context.MODE_PRIVATE)
                val editor = sharedPref.edit()

                editor.putString("nama_lengkap", nama)
                editor.putString("nomor_telepon", hp)
                editor.putString("alamat_user", alamat)
                editor.apply() // Simpan permanen

                Toast.makeText(context, "Data Berhasil Disimpan!", Toast.LENGTH_SHORT).show()

                // Kembali ke halaman Profile
                parentFragmentManager.popBackStack()
            }
        }
    }
}