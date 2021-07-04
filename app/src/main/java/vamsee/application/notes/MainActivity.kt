package vamsee.application.notes

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnClick {

    private lateinit var viewModel: NotesViewModel
    private lateinit var mAdapter: NotesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAdapter = NotesAdapter(this, this)
        allNotes.layoutManager = LinearLayoutManager(this)
        allNotes.adapter = mAdapter

        viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NotesViewModel::class.java)

        viewModel.allNotes.observe(this, { list ->
            list?.let {
                mAdapter.updateNote(it)
            }
        }
        )

    }

    override fun onDelete(note: Notes) {
        viewModel.delete(note)
        Toast.makeText(this, "${note.text} deleted successfully", Toast.LENGTH_SHORT).show()
    }

    fun submitNote(view: View) {
        val note = input.text.toString().trim()
        if(note.isNotEmpty()){
            viewModel.insert(Notes(note))
            input.text.clear()
        }
    }
}