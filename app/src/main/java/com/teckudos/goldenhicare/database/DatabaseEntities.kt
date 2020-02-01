package com.teckudos.goldenhicare.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Category constructor(
    @PrimaryKey
    val id: String,
    val name: String,
    val description: String,
    val url: String
)