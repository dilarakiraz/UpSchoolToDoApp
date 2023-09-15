package com.dilarakiraz.upschooltodoo.ui.dailynotes



import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.dilarakiraz.upschooltodoo.R
import com.dilarakiraz.upschooltodoo.common.viewBinding
import com.dilarakiraz.upschooltodoo.data.model.Note
import com.dilarakiraz.upschooltodoo.data.source.Database
import com.dilarakiraz.upschooltodoo.databinding.DialogAddNoteBinding
import com.dilarakiraz.upschooltodoo.databinding.FragmentDailyNotesBinding

class DailyNotesFragment : Fragment(R.layout.fragment_daily_notes) {

    private val binding by viewBinding (FragmentDailyNotesBinding::bind)

    private val dailyNotesAdapter =  DailyNotesAdapter(
        onNoteClick = ::onNoteClick,
        onDeleteClick = ::onDeleteNote)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            rvDailyNotes.adapter = dailyNotesAdapter
            dailyNotesAdapter.updateList(Database.getDailyNotes())

            fabAdd.setOnClickListener {
                showAddDialog()
            }
        }

    }
    private fun onNoteClick(desc: String) {
        Toast.makeText(requireContext(), desc, Toast.LENGTH_SHORT).show()
    }

    private fun onDeleteNote(note: Note) {
        // CheckBox'a tıklanınca notu silmek ve UI'ı güncellemek için bu işlevi kullanabilirsiniz.
        Database.removeDailyNoteById(note.id)
        dailyNotesAdapter.updateList(Database.getDailyNotes())
    }


    private fun showAddDialog(){
        val builder = AlertDialog.Builder(requireContext())
        val dialogBinding = DialogAddNoteBinding.inflate(layoutInflater)
        builder.setView(dialogBinding.root)
        val dialog = builder.create()

        with(dialogBinding){
            btnAddNote.setOnClickListener {
                val title = etTitle.text.toString()
                val desc = etDesc.text.toString()

                if (title.isNotEmpty() && desc.isNotEmpty()) {
                    Database.addDailyNote(title, desc)
                    dailyNotesAdapter.updateList(Database.getDailyNotes())
                    dialog.dismiss()
                } else {
                    Toast.makeText(requireContext(), "Please fill in the blanks!", Toast.LENGTH_SHORT).show()
                }
            }
        }
        dialog.show()
    }
}
