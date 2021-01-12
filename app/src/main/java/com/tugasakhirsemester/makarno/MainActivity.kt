package com.tugasakhirsemester.makarno

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tugasakhirsemester.makarno.api.RetrofitClient
import com.tugasakhirsemester.makarno.model.IndonesiaResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DataIndonesia()
    }
    private fun DataIndonesia(){
        RetrofitClient.instance.getIndonesia().enqueue(object : Callback<ArrayList<IndonesiaResponse>> {
            //jika gagal menyambungkan ke server
            override fun onFailure(call: Call<ArrayList<IndonesiaResponse>>, t: Throwable) {
                Toast.makeText(this@MainActivity,"${t.message}", Toast.LENGTH_SHORT).show()
            }

            //jika berhasil terhubung ke server maka server akan memberikan response sesuai dengan permintaan pada response body
            override fun onResponse(call: Call<ArrayList<IndonesiaResponse>>, response: Response<ArrayList<IndonesiaResponse>>)
            {
                val DataIndonesia = response.body()?.get(0)
                val dataPositif = DataIndonesia?.positif
                val dataSembuh = DataIndonesia?.sembuh
                val dataMeninggal = DataIndonesia?.meninggal

                confirmed.text = dataPositif
                recovered.text = dataSembuh
                deaths.text = dataMeninggal
            }
        })
    }
}