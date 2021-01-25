package com.example.mynote.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.*
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.mynote.DB.Note
import com.example.mynote.DB.NoteDatabase
import com.example.mynote.R
import kotlinx.android.synthetic.main.fragment_add_note.*
import kotlinx.coroutines.launch

class AddNoteFragment : Basefragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_note, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        button_save.setOnClickListener { view ->

            val noteTitle = titleNote.text.toString().trim()
            val noteBody = writeNote.text.toString().trim()

            if (noteTitle.isEmpty()) {
                titleNote.error = "title required"
                titleNote.requestFocus()
                return@setOnClickListener
            }

            if (noteBody.isEmpty()) {
                writeNote.error = "note required"
                writeNote.requestFocus()
                return@setOnClickListener
            }

            launch {
                val note = Note(noteTitle, noteBody)
                context?.let {
                    NoteDatabase(it).getNoteDao().addNote(note)
                    it.toast("Note Saved")
                    
                    val action = AddNoteFragmentDirections.actionAddNoteFragmentToHomeFragment()
                    Navigation.findNavController(view).navigate(action)
                }
            }



        }
    }

}