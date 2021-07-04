package vamsee.application.notes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(private val context: Context, private val listener: OnClick): RecyclerView.Adapter<ViewHolder>() {

    private val notes: ArrayList<Notes> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.notes_item, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.delete.setOnClickListener{
            listener.onDelete(notes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentNote = notes[position]
        holder.note.text = currentNote.text
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    fun updateNote(list: List<Notes>){
        notes.clear()
        notes.addAll(list)
        notifyDataSetChanged()
    }
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val note = itemView.findViewById<TextView>(R.id.note)
    val delete = itemView.findViewById<ImageView>(R.id.delete)
}

interface OnClick{
    fun onDelete(notes: Notes)
}