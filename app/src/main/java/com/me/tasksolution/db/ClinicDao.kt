package com.me.tasksolution.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.me.tasksolution.model.Clinic

@Dao
interface ClinicDao {

    @Query("SELECT * FROM clinic")
    fun findAllClinics(): LiveData<List<Clinic>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllClinics(characterList: List<Clinic>)
}