package com.example.aslens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aslens.ui.theme.ASLensTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ASLensTheme {
                SetBarColor(color = MaterialTheme.colorScheme.background)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }

    @Composable
    private fun SetBarColor(color: Color) {
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setSystemBarsColor(
                color = color
            )
        }
    }
}

@Preview
@Composable
fun HomeScreen() {
    val logo = painterResource(id = R.drawable.ic_logo)

    Scaffold { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Logo Section
                Image(
                    painter = logo,
                    contentDescription = "App Logo",
                    modifier = Modifier
                        .width(120.dp)
                        .height(120.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))

                // Title Section
                Text(
                    text = "ASLens - Sign Language Interpreter App",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Description Section
                Text(
                    text = "Unlock the power of sign language with interactive lessons, real-time feedback, and personalized paths. Connect with virtual partners and a supportive community. Join us to make learning accessible and fun!",
                    fontSize = 19.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 32.dp)
                )
                Spacer(modifier = Modifier.height(32.dp))

                // Button Section
                Button(
                    onClick = { /* TODO: Navigate to the sign language model page */ },
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .width(200.dp)
                        .height(50.dp)
                ) {
                    Text(text = "Try the Model", fontSize = 18.sp)
                }
            }
        }
    }
}
