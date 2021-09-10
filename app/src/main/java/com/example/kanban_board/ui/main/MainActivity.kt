package com.example.kanban_board.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.kanban_board.R
import com.example.kanban_board.data.database.NoteDatabase
import com.example.kanban_board.databinding.ActivityMainBinding
import com.example.kanban_board.ui.notes.NotesViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: NotesViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        NoteDatabase.getInstance(applicationContext)

    }

    override fun onSupportNavigateUp(): Boolean {
        findNavController(R.id.fragment_host).navigateUp()
        return true
    }

}