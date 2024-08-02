package com.jchunga.lvlapp.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DensitySmall
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jchunga.lvlapp.core.Projects
import com.jchunga.lvlapp.core.Screen
import com.jchunga.lvlapp.presentation.components.CardProject
import com.jchunga.lvlapp.presentation.components.CircleAvatar
import com.jchunga.lvlapp.presentation.components.CustomSearch
import com.jchunga.lvlapp.presentation.navigation.localHomeNavController
import com.jchunga.lvlapp.ui.theme.BlueAccent
import com.jchunga.lvlapp.ui.theme.Geologica
import com.jchunga.lvlapp.ui.theme.Gray
import com.jchunga.lvlapp.ui.theme.LighBlack
import com.jchunga.lvlapp.ui.theme.LighGray
import com.jchunga.lvlapp.ui.theme.BackgroundColor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){

    val navController = localHomeNavController.current

    Scaffold(
        containerColor = BackgroundColor,
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth().padding(20.dp),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BackgroundColor
                ),
                title = {
                    Column {
                        Text("Miguel Liberato", style = MaterialTheme.typography.titleLarge.copy( fontFamily = Geologica, fontWeight = FontWeight.Medium, color = LighBlack))
                        Text("CEO LVL Consulting", style = MaterialTheme.typography.titleSmall.copy(fontFamily = Geologica, fontWeight = FontWeight.Normal, color = Gray))
                    }
                },
                navigationIcon = {
                    CircleAvatar(
                        imageUrl = "https://www.example.com/your-image-url.jpg",
                        size = 60.dp,
                        onClick = {
                            navController.navigate(Screen.Profile.route)
                        }
                    )
                },
                actions = {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .border(
                                1.dp,
                                LighGray,
                                CircleShape
                            )
                    ){
                        IconButton(
                            modifier = Modifier.align(Alignment.CenterEnd) ,
                            onClick = { /*TODO*/ }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.NotificationsNone,
                                contentDescription = null,
                                tint = BlueAccent
                            )
                        }
                    }

                }
            )
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screen.NewProject.route)
                },
                modifier = Modifier
                    .padding(16.dp),
                containerColor = BlueAccent
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Add", tint = Color.White)
            }
        }

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ){
            CustomSearch(
                modifier = Modifier,
                label = "Buscar en tableros",
                value =  "",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = null,
                        tint = BlueAccent
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Filled.DensitySmall ,
                        contentDescription = null,
                        tint = BlueAccent
                    )
                },
                onValueChange = {}
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Tableros",
                modifier = Modifier.padding(horizontal = 20.dp),
                style = MaterialTheme.typography.titleLarge.copy(
                    fontFamily = Geologica,
                    fontWeight = FontWeight.Medium,
                    color = LighBlack
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                items(Projects.size) { index ->
                    CardProject(
                        modifier = Modifier,
                        project = Projects[index]
                    )
                }
                
            }



        }
    }

}


@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen(){
    HomeScreen()
}