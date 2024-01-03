package com.example.bbdd_app.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bbdd_app.model.Tareas

@Database([Tareas::class], version = 2, exportSchema = false)
abstract class DataBase: RoomDatabase() {

    abstract fun tareasToDo(): TareasToDo

    companion object {
        const val DBNAME = "tareas_database"

        @Volatile
        private var INSTANCE: DataBase? = null

        fun getDatabase(context: Context): DataBase {
            val temporalInstance = INSTANCE
            if (temporalInstance != null)
                return temporalInstance

            synchronized(DataBase::class.java) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DataBase::class.java,
                    DBNAME
                ).fallbackToDestructiveMigration().build()

                INSTANCE = instance
                return instance
            }
        }
    }
}