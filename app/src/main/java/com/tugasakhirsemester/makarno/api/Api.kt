package com.tugasakhirsemester.makarno.api

import com.tugasakhirsemester.makarno.model.IndonesiaResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    // Mengambil data kasus covid indonesia
    @GET("indonesia")
    fun getIndonesia(): Call<ArrayList<IndonesiaResponse>>
}

