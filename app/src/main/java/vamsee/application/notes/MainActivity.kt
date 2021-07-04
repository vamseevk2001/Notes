package vamsee.application.notes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), onClick {

    lateinit var viewModel: NotesViewModel
    lateinit var mAdapter: NotesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NotesViewModel::class.java)
//        viewModel.allNotes.observe{
//
//        }

         mAdapter = NotesAdapter(this, this)
        allNotes.layoutManager = LinearLayoutManager(this)
        allNotes.adapter = mAdapter

    }

    override fun onDelete(notes: Notes) {
        TODO("Not yet implemented")
    }
}