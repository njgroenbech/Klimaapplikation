package com.example.klimaaktion.view.createuserscreen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.klimaaktion.model.firebasemodel.Group

@Composable
fun CreateGroupButton(
    onSelect: (Group) -> Unit
) {

    var expanded by remember { mutableStateOf(false) }

    Box {
        Button(onClick = { expanded = true }) {
            Text(
                text = "Lav en ny gruppe"
            )
        }
    }
}