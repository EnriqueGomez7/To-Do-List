package com.example.bbdd_app.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bbdd_app.R
import com.example.bbdd_app.databinding.FragmentTareasBinding


class FragmentTareas : Fragment() {

    private var _binding: FragmentTareasBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: TareasAdapter

    private val myViewModel: TareasViewModel by viewModels {
        TareasViewModel.MyViewModelFactory(requireActivity())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTareasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configRecycler()



        binding.crear.setOnClickListener {

            findNavController().navigate(R.id.action_fragmentTareas_to_fragmentCrear)

        }

        binding.eliminarTodo.setOnClickListener {

            myViewModel.eliminartodo()

        }

        myViewModel.allTareas.observe(viewLifecycleOwner) {
            adapter.updateUserList(it)
        }

    }

    private fun configRecycler() {
        val layoutManager = LinearLayoutManager(requireContext())
        adapter = TareasAdapter(myViewModel)
        binding.recyclerview.layoutManager = layoutManager
        binding.recyclerview.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}