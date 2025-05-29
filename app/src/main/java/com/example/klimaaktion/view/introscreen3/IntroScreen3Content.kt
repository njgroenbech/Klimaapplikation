import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.klimaaktion.view.introscreen3.components.IntroScreen3Cards
import com.example.klimaaktion.view.sharedcomponents.NextButton
import com.example.klimaaktion.view.sharedcomponents.PageIndicator

/**
 * Indholdet for introduktionsskærm 3.
 * Viser overskrift, beskrivelse, en række infokort og navigationskontroller i bunden.
 * Skærmen guider brugeren videre til forsiden.
 */
// Skrevet af Jacob
@Composable
fun IntroScreen3Content(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF8ECBEA)) // Samme blå som øvrige intro-sider
            .padding(24.dp)
    ) {
        // Øverste sektion med tekst og illustrationer
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height(100.dp))

            // Overskrift
            Text(
                text = "Følg",
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF202020)
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Undertekst
            Text(
                text = "Se din fremgang og optjen trofæer!",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF202020)
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Komponent der viser infokort relateret til fremgang og trofæer
            IntroScreen3Cards()
        }

        // Bundsektion med sidemarkør og næste-knap
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
        ) {
            PageIndicator(currentPage = 2) // Viser at vi er på tredje (sidste) intro-side
            Spacer(modifier = Modifier.height(20.dp))

            // Næste-knap navigerer videre til forsiden
            NextButton {
                navController.navigate("frontScreen")
            }
        }
    }
}
