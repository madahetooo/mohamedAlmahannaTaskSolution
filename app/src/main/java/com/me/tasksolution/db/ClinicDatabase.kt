package com.me.tasksolution.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.me.tasksolution.model.Clinic

@Database(
    entities = [Clinic::class],
    version = 1
)
abstract class ClinicDatabase : RoomDatabase() {

    abstract fun createClinicDao() : ClinicDao
    companion object{
        @Volatile
        private var INSTANCE:ClinicDatabase?=null
        fun createDatabase(context: Context):ClinicDatabase{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ClinicDatabase::class.java,
                    "clinic.dp"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}