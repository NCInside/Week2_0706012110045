package com.example.week2_pv.model

import android.net.Uri

class Ayam(
    id: String, nama: String, jenis: String = "Ayam", usia: Int, uri: Uri?
) : Hewan(
    id, nama, jenis, usia, uri
) {

    override fun suara(): String {
        return "Bock bock bock..."
    }

}