package com.example.kanban_board.ui.updateNote

import android.os.Bundle
import android.transition.TransitionInflater
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.kanban_board.R
import com.example.kanban_board.databinding.FragmentNotesBinding
import com.example.kanban_board.databinding.FragmentUpdateBinding
import com.example.kanban_board.ui.notes.NoteAdapter
import com.example.kanban_board.ui.notes.NotesViewModel

class UpdateFragment : Fragment() {

    lateinit var binding: FragmentUpdateBinding
    val args: UpdateFragmentArgs by navArgs()


    private val viewModel: UpdateNoteViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentUpdateBinding.inflate(layoutInflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.updateItem.value = args.noteItem
        viewModel.updateItem.observe(viewLifecycleOwner,{
            viewModel.description.postValue(args.noteItem.description)
            viewModel.assigned.postValue(args.noteItem.assigned)
        })

        binding.back.setOnClickListener {
            Navigation.findNavController(view).popBackStack()
        }

        binding.update.setOnClickListener {
            viewModel.updateNote()
            Navigation.findNavController(view).popBackStack()
        }

    }


}