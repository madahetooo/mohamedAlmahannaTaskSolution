package com.me.tasksolution.service

import com.me.tasksolution.model.Clinic
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


const val BASE_URL = "https://63b61fa558084a7af3aa1d55.mockapi.io/api/v1/"
interface ClinicService {

    @GET("requestPrice")
    suspend fun getClinics() : List<Clinic>
}
object ClinicNetwork {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val serviceApi = retrofit.create(ClinicService::class.java)
}