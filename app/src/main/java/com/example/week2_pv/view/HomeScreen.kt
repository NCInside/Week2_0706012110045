package com.example.week2_pv.view

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.example.week2_pv.navigation.Screen
import com.example.week2_pv.db.HewanList
import com.example.week2_pv.ui.theme.Week2_pvTheme
import com.example.week2_pv.view.component.CustomCard

@Composable
fun HomeScreen(
    navController: NavController
) {

    var showFilterDialog by remember {
        mutableStateOf(false)
    }

    val radioOptions = listOf("Semua" , "Sapi", "Ayam", "Kambing")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }
    val hewans = remember {HewanList.hList}

    Week2_pvTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Black
        ) {
            Scaffold(
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = {
                            navController.navigate(route = Screen.FormScreen.passTitlenId("Tambah"))
                        },
                        backgroundColor = Color(0xFF1f5557),
                        modifier = Modifier.size(64.dp)
                    ) {
                        Icon(Icons.Filled.Add,"", tint = Color.White)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) { padding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black)
                        .padding(1.dp)
                ) {
                    Row (
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Data Hewan",
                            fontSize = 32.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                        Button(
                            onClick = {showFilterDialog = !showFilterDialog},
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF1f5557)),
                            shape = RoundedCornerShape(30.dp),
                            modifier = Modifier
                                .padding(start=144.dp)
                                .size(50.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Search,
                                contentDescription = "Filter",
                                tint = Color.White,
                                modifier = Modifier
                                    .size(40.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    LazyColumn(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items (
                            items = hewans.filter {
                                it.jenis == selectedOption || selectedOption == "Semua"
                            }
                        ) { hewan ->
                            CustomCard(
                                hewan = hewan,
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    }

    if (showFilterDialog) {
        Dialog(
            onDismissRequest = { showFilterDialog = !showFilterDialog },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            )
        ) {
            Card(
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.size(300.dp, 360.dp),
                elevation = 8.dp
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                ) {

                    Text(
                        text = "Filter",
                        modifier = Modifier.padding(16.dp), fontSize = 28.sp, fontWeight = FontWeight.Bold
                    )

                    Column {
                        radioOptions.forEach { text ->
                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .selectable(
                                        selected = (text == selectedOption),
                                        onClick = {
                                            onOptionSelected(text)
                                        }
                                    )
                            ) {
                                RadioButton(
                                    selected = (text == selectedOption),
                                    colors = RadioButtonDefaults.colors(
                                        selectedColor = Color(0xFF1f5557),
                                        unselectedColor = Color.LightGray
                                    ),
                                    onClick = { onOptionSelected(text) }
                                )
                                Text(
                                    text = text,
                                    style = MaterialTheme.typography.body1.merge(),
                                    modifier = Modifier.padding(start = 4.dp, top = 10.dp)
                                )
                            }
                        }
                    }

                    Row(Modifier.padding(top = 10.dp)) {
                        OutlinedButton(
                            onClick = { showFilterDialog = !showFilterDialog },
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF1f5557)),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                                .weight(1F)
                        ) {
                            Text(text = "EXIT", color = Color.White)
                        }
                    }
                }
            }
        }
    }
}