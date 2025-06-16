package com.example.klimaaktion.view.createuserscreen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.example.klimaaktion.model.firebasemodel.SchoolClass

// skrevet af Nicholas, hjælp fra AI til dropdownmenu
@Composable
fun ClassSelectorButton(
    classes: List<SchoolClass>,
    selectedClass: SchoolClass?,
    onSelect: (SchoolClass) -> Unit
) {

    var expanded by remember { mutableStateOf(false) }

    Box {
        Button(
            onClick = { expanded = true },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF6CD59A),
            )
        ) {
            Text(
                text = if (selectedClass != null) selectedClass.name else "Vælg klasse",
                color = Color(0xFF343434)
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            classes.forEach { schoolClass ->
                DropdownMenuItem(
                    text = { Text(schoolClass.name) },
                    onClick = {
                        onSelect(schoolClass)
                        expanded = false
                    }
                )
            }
        }
    }
}