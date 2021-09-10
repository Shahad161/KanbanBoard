package com.example.kanban_board.ui.addNote

import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.kanban_board.databinding.FragmentAddNoteBinding

class AddNoteFragment : Fragment() {

    lateinit var binding: FragmentAddNoteBinding

    private val viewModel: AddNoteViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAddNoteBinding.inflate(layoutInflater)
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

        binding.back.setOnClickListener {
            Navigation.findNavController(view).popBackStack()
        }

        binding.save.setOnClickListener {
            viewModel.addNote()
            Navigation.findNavController(view).popBackStack()
        }
    }




}