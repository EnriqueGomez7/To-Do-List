package com.example.bbdd_app.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.bbdd_app.R
import com.example.bbdd_app.databinding.FragmentCrearBinding
import com.example.bbdd_app.databinding.FragmentTareasBinding
import com.example.bbdd_app.model.Tareas


class FragmentCrear : Fragment() {

    private var _binding: FragmentCrearBinding? = null
    private val binding get() = _binding!!


    private val myViewModel: TareasViewModel by viewModels {
        TareasViewModel.MyViewModelFactory(requireActivity())
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCrearBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.botonCrear.setOnClickListener {

            addTarea()

            findNavController().navigateUp()

        }
    }

    private fun addTarea() {

        val titulo = binding.inputTitulo.text.toString()

        val descripcion = binding.inputDescripcion.text.toString()

        val prioridad = binding.inputPrioridad.text.toString()

        val fechayhora = binding.inputFecha.text.toString()

        if (titulo.isNotEmpty() && descripcion.isNotEmpty() && prioridad.isNotEmpty() && fechayhora.isNotEmpty()) {
            val tarea = Tareas(titulo, descripcion, prioridad.toInt(), fechayhora)
            myViewModel.insertarTarea(tarea)
            binding.inputTitulo.setText("")
            binding.inputDescripcion.setText("")
            binding.inputPrioridad.setText("")
            binding.inputFecha.setText("")
        } else
            Toast.makeText(requireContext(), "Falta información", Toast.LENGTH_SHORT).show()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}