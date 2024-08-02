package com.jchunga.lvlapp.domain.entities

data class Project(
    val id:Int,
    val icon:Int,
    val title:String,
    val code: String,
    val state: ProjectState,
)
