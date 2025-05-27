package com.example.klimaaktion.view.taskscreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.klimaaktion.R
import com.example.klimaaktion.model.Task
import com.example.klimaaktion.viewmodel.MainViewModel

// Nedenstående kode er lavet af Elias
// En lille smule er skrevet af Felix, se kommentare i koden.
// hope this shit works
// UI rettet til af Jacob

@Composable
fun TaskCard(
    task: Task,
    onTaskDone: () -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }
    var detailsExpanded by remember { mutableStateOf(false) }
    var quizExpanded by remember { mutableStateOf(false) }



    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .shadow(6.dp, RoundedCornerShape(20.dp))
            .background(task.backgroundColor, RoundedCornerShape(20.dp))
            .padding(16.dp)
    ) {
        Column {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = task.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.weight(1f))


                // De 2 boxes (bog og spørgsmålstegn ikon, linje 69 - 104) her er skrevet af Felix
                Box(
                    modifier = Modifier
                        .shadow(6.dp, RoundedCornerShape(20.dp))
                        .background(Color(0xFFABE8E4), RoundedCornerShape(50.dp))
                        .size(50.dp)
                        .clickable { detailsExpanded = !detailsExpanded },
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(
                            id = if (detailsExpanded) R.drawable.arrowup else R.drawable.book
                        ),
                        contentDescription = "",
                        modifier = Modifier
                            .size(30.dp)
                    )
                }


                Spacer(modifier = Modifier.width(15.dp))

                Box(
                    modifier = Modifier
                        .shadow(6.dp, RoundedCornerShape(20.dp))
                        .background(Color(0xFFABE8E4), RoundedCornerShape(50.dp))
                        .size(50.dp)
                        .clickable {quizExpanded = !quizExpanded},
                    contentAlignment = Alignment.Center

                ) {
                    Image(
                        painter = painterResource(
                            id = if (quizExpanded) R.drawable.arrowup else R.drawable.questionmark
                        ),
                        contentDescription = "",
                        modifier = Modifier.size(30.dp)
                    )
                }

            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "${task.points} Point",
                fontSize = 18.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Details og Quiz (linje 120-164) er lavet af Felix
            if (detailsExpanded) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = task.details,
                    fontSize = 14.sp
                )
            }

            if (quizExpanded) {
                Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                    task.quiz.forEach { quizQuestion ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFFABE8E4), RoundedCornerShape(20.dp))
                                .padding(12.dp)
                                .padding(vertical = 8.dp)
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = quizQuestion.question,
                                    fontWeight = FontWeight.SemiBold,
                                    modifier = Modifier.padding(bottom = 12.dp),
                                    color = Color.Black
                                )

                                    quizQuestion.answers.forEach { answer ->
                                        Button(
                                            onClick = {},
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .shadow(elevation = 6.dp, shape = RoundedCornerShape(20.dp))
                                                .padding(vertical = 4.dp),
                                            colors = ButtonDefaults.buttonColors(
                                                containerColor = Color.White,
                                                contentColor = Color(0xFF224B43)
                                            ),
                                            shape = RoundedCornerShape(20.dp)
                                        ) {
                                            Text(text = answer)
                                        }
                                    }

                            }
                        }
                    }
                }
            }

            else if (isExpanded == false) {

                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = { isExpanded = true },
                        modifier = Modifier
                            .shadow(elevation = 6.dp, shape = RoundedCornerShape(20.dp))
                            .size(width = 115.dp, height = 50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF224B43),
                            contentColor = Color.White,
                        )
                    ) {
                        Text(
                            text = "Start",
                            fontSize = 20.sp
                        )
                    }
                }

            } else {

                Text(
                    text = task.fact,
                    fontSize = 14.sp
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){

                    Button(
                        modifier = Modifier
                            .shadow(elevation = 6.dp, shape = RoundedCornerShape(20.dp)),
                        onClick = onTaskDone,
                        onClick = {
                            onTaskDone()},
                        colors = ButtonDefaults.buttonColors(Color(0xFF005F3D))
                    ) {
                        Text("Vi har gjort det! (${task.points} point)", color = Color.White)
                    }

                    Button(
                        modifier = Modifier
                            .shadow(elevation = 6.dp, shape = RoundedCornerShape(20.dp)),
                        onClick = { isExpanded = false },
                        colors = ButtonDefaults.buttonColors(Color(0xFF005F3D))
                    ) {
                        Text("Annullér", color = Color.White)
                    }
                }
            }
        }
    }
}