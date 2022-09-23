package com.example.week2_pv.model

import android.net.Uri

class Kambing(
    id: String, nama: String, jenis: String = "Kambing", usia: Int, uri: Uri?
) : Hewan(
    id, nama, jenis, usia, uri
) {

    override fun suara(): String {
        return "Blehhh..."
    }

}