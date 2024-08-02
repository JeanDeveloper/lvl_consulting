package com.jchunga.lvlapp.core

import com.jchunga.lvlapp.domain.entities.IconProject
import com.jchunga.lvlapp.domain.entities.Project
import com.jchunga.lvlapp.domain.entities.ProjectState
import com.jchunga.lvlapp.ui.theme.ColorFinalized
import com.jchunga.lvlapp.ui.theme.ColorInProgress
import com.jchunga.lvlapp.ui.theme.ColorInReview
import com.jchunga.lvlapp.ui.theme.ColorPlanning














val ProjectStates: List<ProjectState> = listOf(
    ProjectState( id = 1,  "EN REVISION", ColorInReview),
    ProjectState( id= 2, name = "EN CURSO", ColorInProgress ),
    ProjectState( id= 3, name = "PLANIFICACION", ColorPlanning),
    ProjectState( id= 4, name = "FINALIZADO", ColorFinalized),
)

val IconProjects: List<IconProject> = listOf(
    IconProject(id = 1, name = "ic_folder", image = com.jchunga.lvlapp.R.drawable.ic_folder),
    IconProject(id = 2, name = "ic_insurance", image = com.jchunga.lvlapp.R.drawable.ic_insurance),
    IconProject(id = 3, name = "ic_briefcase", image = com.jchunga.lvlapp.R.drawable.ic_briefcase),
    IconProject(id = 4, name = "ic_advertising", image = com.jchunga.lvlapp.R.drawable.ic_advertising),
    IconProject(id = 4, name = "ic_email", image = com.jchunga.lvlapp.R.drawable.ic_email),
    IconProject(id = 4, name = "ic_calendar", image = com.jchunga.lvlapp.R.drawable.ic_calendar),
    IconProject(id = 4, name = "ic_cloud_computing", image = com.jchunga.lvlapp.R.drawable.ic_cloud_computing),

)


val Projects: List<Project> = listOf(
    Project( id = 1, title = "Projecto de App", code = "ATA-1", icon = IconProjects[0].image, state = ProjectStates[2]),
    Project( id = 2, title = "Diseño de RR.SS", code = "PA-21", icon = IconProjects[1].image, state = ProjectStates[1]),
    Project( id = 3, title = "Programacion de ...", code = "PA-2", icon = IconProjects[2].image, state = ProjectStates[0]),
    Project( id = 4, title = "Control de Calidad", code = "ATA-1", icon = IconProjects[3].image, state = ProjectStates[3]),
    Project( id = 5, title = "Notificaciones de ...", code = "ATA-1", icon = IconProjects[4].image, state = ProjectStates[2]),
    Project( id = 6, title = "Pago de Ventanilla", code = "PA-2", icon = IconProjects[5].image, state = ProjectStates[0]),
    Project( id = 7, title = "Projecto de App", code = "ATA-1", icon = IconProjects[0].image, state = ProjectStates[2]),
    Project( id = 8, title = "Diseño de RR.SS", code = "PA-21", icon = IconProjects[1].image, state = ProjectStates[1]),
    Project( id = 9, title = "Programacion de ...", code = "PA-2", icon = IconProjects[2].image, state = ProjectStates[0]),
    Project( id = 10, title = "Control de Calidad", code = "ATA-1", icon = IconProjects[3].image, state = ProjectStates[3]),
    Project( id = 11, title = "Notificaciones de ...", code = "ATA-1", icon = IconProjects[4].image, state = ProjectStates[2]),
    Project( id = 12, title = "Pago de Ventanilla", code = "PA-2", icon = IconProjects[5].image, state = ProjectStates[0]),
    Project( id = 14, title = "Projecto de App", code = "ATA-1", icon = IconProjects[0].image, state = ProjectStates[2]),
    Project( id = 15, title = "Diseño de RR.SS", code = "PA-21", icon = IconProjects[1].image, state = ProjectStates[1]),
    Project( id = 16, title = "Programacion de ...", code = "PA-2", icon = IconProjects[2].image, state = ProjectStates[0]),
    Project( id = 17, title = "Control de Calidad", code = "ATA-1", icon = IconProjects[3].image, state = ProjectStates[3]),
    Project( id = 18, title = "Notificaciones de ...", code = "ATA-1", icon = IconProjects[4].image, state = ProjectStates[2]),
    Project( id = 19, title = "Pago de Ventanilla", code = "PA-2", icon = IconProjects[5].image, state = ProjectStates[0])
)




sealed class Screen(val route: String) {
    object Login : Screen("Login Screen")
    object Home : Screen("Home Screen")
    object Splash : Screen("Splash Screen")
    object Profile : Screen("Profile Screen")
    object NewProject : Screen("New Project Screen")
}