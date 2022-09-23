package com.example.week2_pv.model

import android.net.Uri

abstract class Hewan(
    val id: String,
    var nama: String,
    var jenis: String,
    var usia: Int,
    var uri: Uri?
) {
    abstract fun suara() : String
    fun interaksi(tipeMakan: Biji) : String {
        return "Kamu memberi makan hewan dengan " + tipeMakan.nama
    }
    fun interaksi(tipeMakan: Rumput) : String {
        return "Kamu memberi makan hewan dengan " + tipeMakan.nama
    }
}