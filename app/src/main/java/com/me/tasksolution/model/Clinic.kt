package com.me.tasksolution.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "clinic")
data class Clinic(
    @PrimaryKey
    @SerializedName("id")
    val id:Int,
    val name:String,
    val price:String,
    val location: String,
    val distance: String,
    val rate:String,
    val createdFrom:String
) {
}