package com.dilarakiraz.upschooltodoo.ui.dailynotes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dilarakiraz.upschooltodoo.data.model.Note
import com.dilarakiraz.upschooltodoo.databinding.ItemDailyNoteBinding

class DailyNotesAdapter(
    private val onNoteClick: (String) -> Unit
):RecyclerView.Adapter<DailyNotesAdapter.DailyNoteViewHolder>(){

    private val noteList = mutableListOf<Note>()

    override fun onCreateViewHolder(parent:ViewGroup,viewType:Int):DailyNoteViewHolder {
        val binding = ItemDailyNoteBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DailyNoteViewHolder(binding,onNoteClick)
    }

    override fun onBindViewHolder(holder: DailyNoteViewHolder,position: Int){
        holder.bind(noteList[position])
    }

    class DailyNoteViewHolder(
        private val binding: ItemDailyNoteBinding,
        private val onNoteClick: (String) -> Unit
    ):RecyclerView.ViewHolder(binding.root){
        fun bind(note:Note){
            with(binding){
                tvTitle.text = note.title
                tvDesc.text=note.description

                root.setOnClickListener{
                    onNoteClick(note.description)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    fun updateList(list:List<Note>){
        noteList.clear()
        noteList.addAll(list)
        notifyItemRangeChanged(0,list.size)
    }
}