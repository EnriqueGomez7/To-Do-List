package com.example.bbdd_app.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.bbdd_app.R
import com.example.bbdd_app.databinding.VistaTareaBinding
import com.example.bbdd_app.model.Tareas

class TareasAdapter(val viewModel: TareasViewModel) : RecyclerView.Adapter<TareasAdapter.TareasHolder>() {

    var lista = ArrayList<Tareas>()

    inner class TareasHolder(val binding: VistaTareaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TareasHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = VistaTareaBinding.inflate(layoutInflater, parent, false)
        return TareasHolder(binding)
    }


    override fun onBindViewHolder(holder: TareasHolder, position: Int) {
        val tarea = lista[position]

        holder.binding.clave.text = tarea.id.toString()

        holder.binding.titulo.text = "Titulo: ${tarea.titulo}"

        holder.binding.descripcion.text = "Descripción: ${tarea.descripcion}"

        holder.binding.prioridad.text = "Prioridad: ${tarea.prioridad}"

        holder.binding.fechayhora.text = "${tarea.fechayhora}"

        holder.binding.eliminar.setOnClickListener {

            viewModel.eliminarTarea(tarea)

        }

        holder.binding.actualizar.setOnClickListener {

            it.findNavController().navigate(R.id.action_fragmentTareas_to_fragmentCrear)

        }

    }

    override fun getItemCount(): Int {
        return lista.size
    }

    fun updateUserList(arrayList: List<Tareas>) {
        lista.clear()
        lista.addAll(arrayList)
        notifyDataSetChanged()
    }

}