package com.example.klimaaktion.view.createuserscreen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction

// Skrevet af Nicholas, hjælp fra AI til showDialog opsætning
@Composable
fun CreateGroupButton(
    onCreate: (String) -> Unit
) {
    var groupName by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }

    Button(
        onClick = { showDialog = true },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF6CD59A),
        )
    ) {
        Text("Opret Gruppe",color = Color(0xFF343434))
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = {
                showDialog = false
                groupName = ""
            },
            title = {
                Text("Indtast gruppenavn")
            },
            text = {
                OutlinedTextField(
                    value = groupName,
                    onValueChange = { groupName = it },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            if (groupName.isNotBlank()) {
                                showDialog = false
                                groupName = ""
                            }
                        }
                    ),
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        if(groupName.isNotBlank()) {
                            onCreate(groupName)
                            showDialog = false
                            groupName = ""
                        }
                    }
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.CenterHorizontally),
                        text = "Opret"
                    )
                }
            },
        )
    }
}