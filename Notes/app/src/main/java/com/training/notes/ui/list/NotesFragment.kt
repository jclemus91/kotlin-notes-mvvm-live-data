package com.training.notes.ui.list

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.training.notes.R
import com.training.notes.model.Note
import kotlinx.android.synthetic.main.notes_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel

class NotesFragment : Fragment() {

    private val viewModel: NotesViewModel by viewModel()
    private lateinit var notesAdapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.notes_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Adapter
        notesAdapter = NotesAdapter()
        rvNotes.adapter = notesAdapter
        notesAdapter.setOnNoteClick {
            val args = Bundle()
            args.putInt("note_index", it)
            findNavController().navigate(R.id.action_notesFragment_to_noteDetailFragment, args)
        }

        // View Model
        viewModel.setUp()
        viewModel.notesLive.observe(this, Observer {
            if (it.isNotEmpty()) {
                notesAdapter.addNotes(it)
                if (rvNotes.visibility != View.VISIBLE) {
                    rvNotes.visibility = View.VISIBLE
                    tvEmpty.visibility = View.GONE
                }
            } else if (tvEmpty.visibility != View.VISIBLE) {
                tvEmpty.visibility = View.VISIBLE
                rvNotes.visibility = View.GONE
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_add -> {
                findNavController().navigate(R.id.action_notesFragment_to_addNoteFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private class NotesAdapter : RecyclerView.Adapter<NotesAdapter.NoteVH>() {

        private val notes = arrayListOf<Note>()
        private var onNoteClick: ((noteIndex: Int) -> Unit)? = null

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteVH {
            val rowView = LayoutInflater.from(parent.context)
                .inflate(R.layout.note_row, parent, false)
            return NoteVH(rowView)
        }

        override fun getItemCount(): Int = notes.size

        override fun onBindViewHolder(holder: NoteVH, position: Int) {
            holder.bind(notes[position])
        }

        fun addNotes(notes: List<Note>) {
            this.notes.clear()
            this.notes.addAll(notes)
            notifyDataSetChanged()
        }

        fun setOnNoteClick(onNoteClick: ((noteIndex: Int) -> Unit)?) {
            this.onNoteClick = onNoteClick
        }

        private inner class NoteVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

            private val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)

            init {
                itemView.setOnClickListener { onNoteClick?.invoke(adapterPosition) }
            }

            fun bind(note: Note) {
                tvTitle.text = note.title
            }
        }
    }
}