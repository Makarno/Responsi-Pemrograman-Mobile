package com.tugasakhirsemester.makarno.model

data class IndonesiaResponse(
        // menggunakan vall dikarenakan nama variabel sudah di deklarasikan pada api maka
        // kita tidak dapat mengubahnya
        val positif: String,
        val sembuh: String,
        val meninggal: String,
        )