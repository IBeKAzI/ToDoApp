package com.example.todoapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.databinding.FragmentHomeBinding
import com.example.todoapp.ui.adapter.TodoAdapter
import com.example.todoapp.ui.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import android.text.Editable
import android.text.TextWatcher
import com.example.todoapp.R
import com.example.todoapp.utils.gecisYap

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: TodoAdapter
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // ToDo listesi güncellendikçe adapteri güncelle
        viewModel._toDoList.observe(viewLifecycleOwner) { todoList ->
            adapter = TodoAdapter(requireContext(), todoList, viewModel)
            binding.recyclerView.adapter = adapter
        }

        // FAB ➜ AddFragment'a yönlendirme
        binding.fabAdd.setOnClickListener {
            Navigation.gecisYap(it, R.id.homeToAdd)
        }

        // Arama kutusu
        binding.editTextSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                viewModel.search(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }
}
