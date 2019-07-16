package com.training.notes.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.training.notes.R
import kotlinx.android.synthetic.main.add_note_fragment.buttonCancel
import kotlinx.android.synthetic.main.add_note_fragment.buttonSave
import kotlinx.android.synthetic.main.add_note_fragment.etDescription
import kotlinx.android.synthetic.main.add_note_fragment.etTitle
import org.koin.android.viewmodel.ext.android.viewModel

class AddNoteFragment : Fragment() {

    private val viewModel: AddNoteViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.add_note_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonSave.setOnClickListener {
            viewModel.addNote(
                etTitle.text.toString(),
                etDescription.text.toString()
            )
            findNavController().popBackStack()
        }
        buttonCancel.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}
