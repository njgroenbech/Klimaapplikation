package com.example.klimaaktion.view.createuserscreen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.klimaaktion.model.firebasemodel.Group
import kotlin.collections.forEach

@Composable
fun GroupSelectorButton(
    groups: List<Group>,
    selectedGroup: Group?,
    onSelect: (Group) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        // The main button shows either the selected group or a prompt
        Button(onClick = { expanded = true }) {
            Text(text = selectedGroup?.name ?: "Vælg gruppe")
        }

        // The dropdown menu anchors to that button
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            groups.forEach { group ->
                DropdownMenuItem(
                    text = { Text(group.name) },
                    onClick = {
                        onSelect(group)
                        expanded = false
                    }
                )
            }
        }
    }
}