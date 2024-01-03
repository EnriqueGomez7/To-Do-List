package com.example.bbdd_app.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Tareas(
    var titulo: String,
    var descripcion: String,
    var prioridad: Int,
    var fechayhora: String)
{

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}