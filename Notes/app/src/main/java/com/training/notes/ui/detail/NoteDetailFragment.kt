package com.training.notes.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.training.notes.R
import kotlinx.android.synthetic.main.note_detail_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel

class NoteDetailFragment : Fragment() {

    private val viewModel: NoteDetailViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.note_detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.setUp(arguments?.getInt("note_index") ?: -1)
        viewModel.noteLive.observe(this, Observer {
            tvTitle.text = it.title
            tvDescription.text = it.message
        })
    }
}
