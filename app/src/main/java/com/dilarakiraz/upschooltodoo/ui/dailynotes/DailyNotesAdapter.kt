package com.dilarakiraz.upschooltodoo.ui.dailynotes


import android.os.Handler
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dilarakiraz.upschooltodoo.data.model.Note
import com.dilarakiraz.upschooltodoo.data.source.Database
import com.dilarakiraz.upschooltodoo.databinding.ItemDailyNoteBinding


class DailyNotesAdapter(
    private val onNoteClick: (String) -> Unit,
    private val onDeleteClick: (Note) -> Unit
):RecyclerView.Adapter<DailyNotesAdapter.DailyNoteViewHolder>(){

    private val noteList = mutableListOf<Note>()

    override fun onCreateViewHolder(parent:ViewGroup,viewType:Int):DailyNoteViewHolder {
        val binding = ItemDailyNoteBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DailyNoteViewHolder(binding,onNoteClick, onDeleteClick)
    }

    override fun onBindViewHolder(holder: DailyNoteViewHolder,position: Int){
        holder.bind(noteList[position])
    }

    class DailyNoteViewHolder(
        private val binding: ItemDailyNoteBinding,
        private val onNoteClick: (String) -> Unit,
        private val onDeleteClick: (Note) -> Unit
    ):RecyclerView.ViewHolder(binding.root){

        private var note: Note? = null
        private val handler = Handler()

        fun bind(note:Note){


            this.note = note

            with(binding){
                tvTitle.text = note.title
                tvDesc.text=note.description

                root.setOnClickListener{
                    onNoteClick(note.description)
                }


                checkbox.isChecked = note.isChecked

                checkbox.setOnCheckedChangeListener { _, isChecked ->
                    // CheckBox durumu değiştiğinde notun isChecked özelliğini güncelle
                    note.isChecked = isChecked
                }

                checkbox.setOnClickListener {
                    // CheckBox'a tıklanınca tik işareti gözüksün
                    checkbox.isChecked = true
                    // Bir süre sonra notun silinmesini sağla
                    handler.postDelayed({
                        onDeleteClick(note!!)
                    }, 1000) // Örneğin, 1000 milisaniye (1 saniye) sonra silme işlemini gerçekleştir
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
        //notifyItemRangeChanged(0,list.size)
        notifyDataSetChanged()
    }

}