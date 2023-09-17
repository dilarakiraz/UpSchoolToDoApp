package com.dilarakiraz.upschooltodoo.data.model

data class Note(
    val id:Int,
    val title:String,
    val description:String,
    var isChecked: Boolean = false,
    val priorityColorResId: Int
)
