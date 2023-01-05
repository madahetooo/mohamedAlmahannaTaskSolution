package com.me.tasksolution.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.me.tasksolution.repository.ClinicRepository
import kotlinx.coroutines.launch

class ClinicViewModel(private val clinicRepository: ClinicRepository) : ViewModel() {

    init {
        refreshData()
    }
    val clinicList = clinicRepository.clinics

    //Calling Data from Repository
    fun refreshData() {
        viewModelScope.launch {
            clinicRepository.getClinics()
        }
    }
}

@Suppress("UNCHECKED_CAST")
class ClinicViewModelFactory(private val clinicRepository: ClinicRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ClinicViewModel::class.java)) {
            return ClinicViewModel(clinicRepository) as T

        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}