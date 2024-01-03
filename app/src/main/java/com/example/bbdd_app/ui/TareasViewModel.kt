package com.example.bbdd_app.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bbdd_app.data.Repository
import com.example.bbdd_app.data.room.DataBase
import com.example.bbdd_app.model.Tareas
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TareasViewModel(val context: Context) : ViewModel() {

    private val pelisDao = DataBase.getDatabase(context).tareasToDo()
    private val repository = Repository(pelisDao)

    val allTareas = repository.obtenerTodasLasTareas()



    fun insertarTarea(tarea: Tareas) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.crearTarea(tarea)
        }
    }

    fun eliminartodo(){

        CoroutineScope(Dispatchers.IO).launch {
            repository.eliminarTodaslasTareas()
        }

    }

    fun actualizartarea(tarea: Tareas){

        CoroutineScope(Dispatchers.IO).launch {
            repository.actualizartarea(tarea)
        }

    }

    fun eliminarTarea(tarea: Tareas) =
        CoroutineScope(Dispatchers.IO).launch {
            repository.eliminarTarea(tarea)
        }

    class MyViewModelFactory(val context: Context) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(Context::class.java)
                .newInstance(context)
        }
    }


}