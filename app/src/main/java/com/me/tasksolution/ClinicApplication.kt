package com.me.tasksolution

import android.app.Application
import com.me.tasksolution.db.ClinicDatabase
import com.me.tasksolution.repository.ClinicRepository

class ClinicApplication : Application() {

    val database by lazy {
        ClinicDatabase.createDatabase(this)
    }

    val clinicRepository by lazy {
        ClinicRepository(database.createClinicDao())
    }
}