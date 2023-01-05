package com.me.tasksolution.repository

import androidx.lifecycle.LiveData
import com.me.tasksolution.db.ClinicDao
import com.me.tasksolution.model.Clinic
import com.me.tasksolution.service.ClinicNetwork
import com.me.tasksolution.service.ClinicService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ClinicRepository(private val clinicDao:ClinicDao) {
    var clinics: LiveData<List<Clinic>> = clinicDao.findAllClinics()

    suspend fun getClinics(){
        withContext(Dispatchers.IO){
            val clinics = ClinicNetwork.serviceApi.getClinics()
            clinicDao.insertAllClinics(clinics)
        }
    }
}