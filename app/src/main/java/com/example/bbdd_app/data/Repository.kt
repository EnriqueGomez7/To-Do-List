package com.example.bbdd_app.data

import androidx.lifecycle.LiveData
import androidx.room.Insert
import com.example.bbdd_app.data.room.TareasToDo
import com.example.bbdd_app.model.Tareas

class Repository(private val tareasToDo: TareasToDo) {

    suspend fun crearTarea(tarea: Tareas) {

        tareasToDo.crearTarea(tarea)

    }

    suspend fun actualizartarea(tarea: Tareas) {

        tareasToDo.actualizarTarea(tarea)

    }

    fun obtenerTodasLasTareas() : LiveData<List<Tareas>> {
        return tareasToDo.obtenerTodasLasTareas()
    }

    suspend fun eliminarTarea(tarea: Tareas) {
        tareasToDo.eliminarTarea(tarea)
    }

    suspend fun eliminarTodaslasTareas() {

         tareasToDo.eliminarTodaslasTareas()
    }

}