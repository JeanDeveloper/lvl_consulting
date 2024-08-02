package com.jchunga.lvlapp.presentation.viewmodel

import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.lifecycle.ViewModel
import com.jchunga.lvlapp.core.IconProjects
import com.jchunga.lvlapp.core.ProjectStates
import com.jchunga.lvlapp.domain.entities.IconProject
import com.jchunga.lvlapp.domain.entities.ProjectState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class NewProjectViewModel @Inject constructor() : ViewModel() {

    private val _iconSelected = MutableStateFlow(IconProjects.random())
    val iconSelected : StateFlow<IconProject> = _iconSelected

    private val _nameProject = MutableStateFlow("")
    val nameProject : StateFlow<String> = _nameProject

    private val _descriptionProject = MutableStateFlow("")
    val descriptionProject : StateFlow<String> = _descriptionProject

    private val _stateSelected = MutableStateFlow<ProjectState?>(ProjectStates[0])
    val stateSelected : StateFlow<ProjectState?> = _stateSelected

    private val _share = MutableStateFlow (false)
    val share : StateFlow<Boolean> = _share

    fun onNameChanged(name:String){
        _nameProject.value = name
    }

    fun onDescriptionChanged(description:String){
        _descriptionProject.value = description
    }

    fun onStateChanged(state:ProjectState?){
        _stateSelected.value = state
    }

    fun changeRandomIcon(){
        _iconSelected.value = IconProjects.random()
    }

    fun onSharedMemberChange( value:Boolean ){
        _share.value = value
    }


}