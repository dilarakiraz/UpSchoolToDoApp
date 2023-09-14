package com.dilarakiraz.upschooltodoo.ui.dailynotes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dilarakiraz.upschooltodoo.data.model.Note
import com.dilarakiraz.upschooltodoo.databinding.ItemDailyNoteBinding

class DailyNotesAdapter(

):RecyclerView.Adapter<DailyNotesAdapter.DailyNoteViewHolder>(){

    private val noteList = mutableListOf<Note>()

    override fun onCreateViewHolder(parent:ViewGroup,viewType:Int):DailyNoteViewHolder {
        val binding = ItemDailyNoteBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DailyNoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DailyNoteViewHolder,position: Int){
        holder.bind(noteList[position])
    }

    class DailyNoteViewHolder(private val binding: ItemDailyNoteBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(note:Note){
            with(binding){

            }
        }
    }

    override fun getItemCount(): Int {
        return noteList.size
    }
}