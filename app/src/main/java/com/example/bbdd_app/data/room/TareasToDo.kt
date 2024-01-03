package com.example.bbdd_app.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.bbdd_app.model.Tareas

@Dao
interface TareasToDo {

    @Insert
    suspend fun crearTarea(tarea: Tareas)

    @Delete
    suspend fun eliminarTarea(tarea: Tareas)

    @Update
    suspend fun actualizarTarea(tarea: Tareas)

    @Query("SELECT * FROM tareas")
    fun obtenerTodasLasTareas(): LiveData<List<Tareas>>

    @Query("DELETE FROM tareas")
    suspend fun eliminarTodaslasTareas()

}