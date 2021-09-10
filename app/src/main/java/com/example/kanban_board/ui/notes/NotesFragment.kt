package com.example.kanban_board.ui.notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigatorExtras
import com.example.kanban_board.R
import com.example.kanban_board.databinding.FragmentNotesBinding

class NotesFragment : Fragment() {

    lateinit var binding: FragmentNotesBinding

    private val viewModel: NotesViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentNotesBinding.inflate(layoutInflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val noteAdapter = NoteAdapter(mutableListOf(), viewModel)
        binding.recyclerNote.adapter = noteAdapter

        binding.addButton.setOnClickListener {
            val action = NotesFragmentDirections.actionNotesFragmentToAddNoteFragment()
            val extras = FragmentNavigatorExtras(
                binding.view to "backgroundTransition")
            Navigation.findNavController(view).navigate(action, extras)
        }

        viewModel.notesItem.observe(viewLifecycleOwner, {
            if (it != null ) {
                val action = NotesFragmentDirections.actionNotesFragmentToUpdateFragment(it)
                val extras = FragmentNavigatorExtras(
                    binding.view to "backgroundTransition")
                Navigation.findNavController(view).navigate(action, extras)
            }
        })

    }


    override fun onStop() {
        super.onStop()
        viewModel.notesItem.value = null
    }

}