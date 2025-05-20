package com.example.todoapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.todoapp.databinding.FragmentDetailBinding
import com.example.todoapp.ui.viewmodels.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val viewModel: DetailViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs() // SafeArgs kullanımı

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val todo = args.todo

        binding.editTextUpdateName.setText(todo.name)

        binding.buttonUpdate.setOnClickListener {
            val updatedName = binding.editTextUpdateName.text.toString().trim()
            if (updatedName.isNotEmpty()) {
                viewModel.guncelle(todo.id, updatedName)
                Toast.makeText(requireContext(), "Görev güncellendi", Toast.LENGTH_SHORT).show()
                requireActivity().onBackPressedDispatcher.onBackPressed()
            } else {
                Toast.makeText(requireContext(), "İsim boş olamaz", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
