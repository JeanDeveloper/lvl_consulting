package com.jchunga.lvlapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jchunga.lvlapp.R
import com.jchunga.lvlapp.domain.entities.Project
import com.jchunga.lvlapp.domain.entities.ProjectState
import com.jchunga.lvlapp.ui.theme.ColorInProgress
import com.jchunga.lvlapp.ui.theme.ColorInReview
import com.jchunga.lvlapp.ui.theme.ColorPlanning
import com.jchunga.lvlapp.ui.theme.Geologica
import com.jchunga.lvlapp.ui.theme.Gray
import com.jchunga.lvlapp.ui.theme.LighBlack
import com.jchunga.lvlapp.ui.theme.LighGray

@Composable
fun CardProject(
    modifier: Modifier,
    project: Project
){
    Box{
        Image(
            painter = painterResource(id = R.drawable.folder),
            contentDescription = null,
            modifier = Modifier
//                .size(200.dp)
                .align(Alignment.Center)
        )

        Column(
            modifier = Modifier.align(Alignment.Center)
        ) {
            CircleIcon(
                image = project.icon,
            )

            Text(project.title, style = MaterialTheme.typography.titleSmall.copy( fontFamily = Geologica, fontWeight = FontWeight.Medium, color = LighBlack) )
            Text(project.code, style = MaterialTheme.typography.titleSmall.copy( fontFamily = Geologica, fontWeight = FontWeight.Medium, color = Gray))
            StateText(project.state)
        }
    }
}

@Composable
fun StateText(
    state: ProjectState
){
    Text(
        state.name,
        modifier = Modifier.background(state.color),
        style = MaterialTheme.typography.titleSmall.copy(
            fontFamily = Geologica,
            fontWeight = FontWeight.Medium,
            color = LighBlack
        )
    )
}

//@Preview
//@Composable
//fun PreviewCardProject(){
//    CardProject(
//        modifier = Modifier
//    )
//}