package com.dilarakiraz.upschooltodoo.data.source

import com.dilarakiraz.upschooltodoo.data.model.Note

object Database {
    private val dailyNotes = mutableListOf<Note>()

    fun getDailyNotes():List<Note>{
        return dailyNotes
    }
    fun addDailyNote(title:String,description:String){
        val newNote=Note(
            id= (dailyNotes.lastOrNull()?.id ?:0) + 1,
            title=title,
            description=description
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