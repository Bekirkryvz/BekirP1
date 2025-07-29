package com.example.bekir_p1.componentsB

import android.media.Image
import android.util.Log
import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bekir_p1.viewmodels.UserViewModel
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import com.example.bekir_p1.ui.theme.LightBlue

@Composable
fun MenuButton(
    userViewModel: UserViewModel, modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    Box(
        modifier = modifier
//            .fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 25.dp, end = 25.dp, bottom = 10.dp)
                .size(50.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            colors = CardDefaults.cardColors(containerColor = LightBlue),
            shape = CircleShape,
        ) {
            Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                Log.d(
                    context.toString(),
                    "MenuButton clicked. New editMode: ${userViewModel.editMode}"
                )
                IconButton(
                    onClick = {
                        userViewModel.editMode = !userViewModel.editMode
                    }, modifier = Modifier.fillMaxSize()
                ) {
                    Icon(imageVector = Icons.Filled.Menu, contentDescription = "Edit")
                }
            }
        }
    }
}

@Composable
fun PageX(
    userViewModel: UserViewModel = viewModel(), modifier: Modifier = Modifier
) {
    //val userViewModel: UserViewModel = viewModel()
    val edit = userViewModel.editMode
    val pageNum = userViewModel.currentPage
    val name = userViewModel.names[pageNum]
    val age = userViewModel.ages[pageNum]
//    MenuButton(userViewModel = userViewModel, modifier = Modifier, onToggleEditMode = {})
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var showEditDialog by remember { mutableStateOf(false) }
        var dialogField by remember { mutableStateOf("") }
        var dialogLabel by remember { mutableStateOf("") }
        Box(
            modifier = Modifier
                .background(LightBlue, shape = CircleShape)
                .size(200.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            when (pageNum) {
                0 -> Image(
                    painter = painterResource(id = com.example.bekir_p1.R.drawable.profile_img1),
                    contentDescription = "Profile Image1",
                    modifier = Modifier
                        .size(190.dp)
                        .clip(CircleShape)
                        .padding(8.dp)
                        .align(Alignment.Center)
                )
                1 -> Image(
                    painter = painterResource(id = com.example.bekir_p1.R.drawable.profile_img2),
                    contentDescription = "Profile Image1",
                    modifier = Modifier
                        .size(190.dp)
                        .clip(CircleShape)
                        .padding(8.dp)
                        .align(Alignment.Center)
                )
                2-> Image(
                    painter = painterResource(id = com.example.bekir_p1.R.drawable.profile_img3),
                    contentDescription = "Profile Image1",
                    modifier = Modifier
                        .size(190.dp)
                        .clip(CircleShape)
                        .padding(8.dp)
                        .align(Alignment.Center)
                )
            }

        }
        Spacer(modifier = Modifier.size(20.dp))
        EditableRow(
            modifier = Modifier.padding(8.dp), label = "Name", value = name, onValueChange = {
                dialogLabel = "Name"
                dialogField = name
                showEditDialog = true
            }, editMode = edit, fontSize = 25
        )


        EditableRow(
            modifier = Modifier.padding(8.dp),
            label = "Age",
            value = age.toString(),
            onValueChange = {
                dialogLabel = "Age"
                dialogField = age.toString()
                showEditDialog = true
            },
            editMode = edit,
            fontSize = 20
        )
        CheckEditDialog(
            showDialog = showEditDialog,
            dialogField = dialogField,
            onValueChange = { dialogField = it },
            onDismiss = { showEditDialog = false },
            onSave = {
                val page = userViewModel.currentPage
                if (dialogLabel == "Name") {
                    userViewModel.names[page] = dialogField
                } else if (dialogLabel == "Age") {
                    userViewModel.ages[page] = dialogField.toIntOrNull() ?: 0
                }
                showEditDialog = false
            },
            label = dialogLabel
        )

    }
}


