package com.example.bekir_p1.componentsB

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.TextField

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bekir_p1.ui.theme.LightBlue
import com.example.bekir_p1.ui.theme.DarkBlue
import com.example.bekir_p1.ui.theme.LighterBlue

import com.example.bekir_p1.viewmodels.UserViewModel


@Composable
fun EditableRow(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    fontSize: Int,
    editMode: Boolean,
) {
    Log.d("EditableRow", "editMode = $editMode")
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                fontSize = fontSize.sp,
                text = "$label: $value",
            )
        }
        if (editMode) {
            Card(
                modifier = Modifier
                    .size(50.dp)
                    .padding(8.dp),
                elevation = CardDefaults.cardElevation(8.dp),
                colors = CardDefaults.cardColors(containerColor = LightBlue),

                ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton(onClick = { onValueChange(value) }) {
                        Icon(
                            modifier = Modifier.padding(8.dp),
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Edit $label",
                        )
                    }
                }
            }
        }
    }
    val showDialog = remember { mutableStateOf(false) }
    val tempValue = remember { mutableStateOf(value) }
    CheckEditDialog(
        showDialog = showDialog.value,
        dialogField = tempValue.value,
        onValueChange = { tempValue.value = it },
        onDismiss = { showDialog.value = false },
        onSave = {
            onValueChange(tempValue.value)
            showDialog.value = false
        },
        label = label
    )
}

@Composable
fun CheckEditDialog(
    modifier: Modifier = Modifier,
    showDialog: Boolean,
    dialogField: String,
    onValueChange: (String) -> Unit,
    onDismiss: () -> Unit,
    onSave: () -> Unit,
    label: String,
) {
    if (showDialog) {
        AlertDialog(
            modifier = modifier,
            onDismissRequest = { onDismiss() },
            title = { Text(text = "Edit $label") },
            text = { TextField(value = dialogField, onValueChange = onValueChange) },
            confirmButton = { Button(onClick = { onSave() }) { Text(text = "Save") } },
            dismissButton = { Button(onClick = { onDismiss() }) { Text(text = "Cancel") } }
        )
    }
}

@Composable
fun BottomPageIndicator(
    modifier: Modifier = Modifier,
    userViewModel: UserViewModel,
    currentPage: Int,
    totalPages: Int,

    ) {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Row (
                modifier = Modifier.background(color = LightBlue, shape = RoundedCornerShape(50)),
        ){
            repeat(totalPages) { index ->
                Box(
                    modifier = modifier
                        .padding(horizontal = 4.dp)
                        .size(10.dp)
                        .background(
                            color = if (index == currentPage) DarkBlue else LighterBlue,
                            shape = CircleShape)

                ){

                }

            }
        }
    }
}













