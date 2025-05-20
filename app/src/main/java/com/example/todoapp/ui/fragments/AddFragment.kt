package com.example.todoapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.todoapp.databinding.FragmentAddBinding
import com.example.todoapp.ui.viewmodels.AddViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding
    private val viewModel: AddViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonAdd.setOnClickListener {
            val todoName = binding.editTextToDoName.text.toString().trim()
            if (todoName.isNotEmpty()) {
                viewModel.ekle(todoName)
                Toast.makeText(requireContext(), "Görev eklendi", Toast.LENGTH_SHORT).show()
                Navigation.findNavController(it).popBackStack()
            } else {
                Toast.makeText(requireContext(), "Görev adı boş olamaz", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
