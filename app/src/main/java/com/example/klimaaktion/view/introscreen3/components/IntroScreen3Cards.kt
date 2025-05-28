import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.klimaaktion.R

@Composable
fun IntroScreen3Cards() {
    Column(
        verticalArrangement = Arrangement.spacedBy(32.dp) // Mere spacing mellem kortene
    ) {
        // Progress Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFF9B9B)),
            shape = RoundedCornerShape(32.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 20.dp, top = 24.dp, bottom = 24.dp, end = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.width(100.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier.size(100.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Canvas(modifier = Modifier.size(100.dp)) {
                            drawCircle(
                                color = Color(0xFF003B4A),
                                radius = size.minDimension / 2,
                                style = Stroke(width = 12.dp.toPx()) // lidt tyndere
                            )
                            drawArc(
                                color = Color(0xFF73D8B6),
                                startAngle = -90f,
                                sweepAngle = 120f,
                                useCenter = false,
                                style = Stroke(width = 12.dp.toPx(), cap = StrokeCap.Round)
                            )
                        }

                        Text(
                            text = "33%",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "I er på level 2",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(2.dp))

                    Box(modifier = Modifier.padding(start = 1.dp)) {
                        Text(
                            text = "53 point / 160",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color(0xFF003B4A),
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                        )
                    }
                }

                Spacer(modifier = Modifier.width(20.dp))

                Column(
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                    modifier = Modifier.fillMaxHeight()
                ) {
                    Text(
                        text = "Leaderboard",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    listOf(
                        Triple("1", "Klimaklubben", "53"),
                        Triple("2", "De Grønne Riddere", "32"),
                        Triple("3", "Eco Eagles", "18")
                    ).forEach { (rank, name, score) ->
                        Row(
                            modifier = Modifier
                                .background(Color(0xFF9AEBA3), RoundedCornerShape(50))
                                .padding(horizontal = 12.dp, vertical = 4.dp)
                                .widthIn(max = 180.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(rank, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.Black)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(name, fontSize = 14.sp, color = Color.Black, modifier = Modifier.weight(1f))
                            Text(score, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.Black)
                        }
                    }
                }
            }
        }

        // Trophy Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFE3F2FD)),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp, vertical = 12.dp)
            ) {
                // Toplinje: Titel + ikoner
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Trofæer",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        painter = painterResource(id = R.drawable.trophy_icon),
                        contentDescription = "Trophy",
                        tint = Color.Unspecified,
                        modifier = Modifier.size(30.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.settings_icon),
                        contentDescription = "Settings",
                        tint = Color.Unspecified,
                        modifier = Modifier.size(30.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Trofæ-ikoner
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.plantbased_trophy_icon),
                        contentDescription = "Plant Trophy",
                        modifier = Modifier.size(54.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.bike_trophy_icon),
                        contentDescription = "Bike Trophy",
                        modifier = Modifier.size(54.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.seed_trophy_icon),
                        contentDescription = "Seed Trophy",
                        modifier = Modifier.size(54.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.light_trophy_icon),
                        contentDescription = "Final Trophy",
                        modifier = Modifier.size(54.dp)
                    )
                }

                Spacer(modifier = Modifier.height(18.dp))

                HorizontalDivider(
                    thickness = 1.dp,
                    color = Color.Black
                )
            }
        }
    }
}