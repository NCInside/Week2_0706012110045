package com.example.week2_pv.model

import android.net.Uri

class Sapi(
    id: String, nama: String, jenis: String = "Sapi", usia: Int, uri: Uri?
) : Hewan(
    id, nama, jenis, usia, uri
) {

    override fun suara(): String {
        return "Mooooooo..."
    }

}