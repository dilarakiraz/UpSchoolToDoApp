package com.dilarakiraz.upschooltodoo.data.source

import com.dilarakiraz.upschooltodoo.data.model.Note
import com.dilarakiraz.upschooltodoo.data.model.Priority

object Database {
    private val dailyNotes = mutableListOf<Note>()

    fun getDailyNotes():List<Note>{
        return dailyNotes
    }
    fun addDailyNote(title:String,description:String, priorityColorResId: Int){
        val newNote=Note(
            id= (dailyNotes.lastOrNull()?.id ?:0) + 1,
            title=title,
            description=description,
            priorityColorResId = priorityColorResId
        )
        dailyNotes.add(newNote)
    }
    fun removeDailyNoteById(id: Int) {
        val noteToRemove = dailyNotes.find { it.id == id }
        if (noteToRemove != null) {
            dailyNotes.remove(noteToRemove)
        }
    }

}