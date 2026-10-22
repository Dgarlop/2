package com.example.meteolocal

import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Arrangement
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.meteolocal.ui.theme.MeteoLocalTheme
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MeteoLocalTheme {
                MeteoLocalApp()
            }
        }
    }
}
@Composable
fun MeteoLocalApp() {
    var localidad by remember {
        mutableStateOf("")
    }
    var mensaje by remember {
        mutableStateOf("Introduce una localidad")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "MeteoLocal",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Text(
            text = "Consulta el tiempo de cualquier localidad"
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )
        OutlinedTextField(
            value = localidad,
            onValueChange = { nuevoValor: String ->
                localidad = nuevoValor
            },
            label = {
                Text("Localidad")
            },
            singleLine = true
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Button(
            onClick = {
                if (localidad.isBlank()) {
                    mensaje = "Introduce una localidad"
                } else {
                    mensaje = "Consulta preparada para: $localidad"
                }
            }
        ) {
            Text("Consultar")
        }

    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MeteoLocalTheme {
        Greeting("Android")
    }
}