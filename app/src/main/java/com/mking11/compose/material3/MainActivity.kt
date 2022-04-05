package com.mking11.compose.material3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mking11.compose.buttons.*
import com.mking11.compose.buttons.utils.EmphasisLevel
import com.mking11.compose.buttons.utils.IconPlacing
import com.mking11.compose.material3.ui.theme.ComposeMaterial30Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMaterial30Theme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .focusable(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {


                    M3Button(onClick = { /*TODO*/ }, text = "Standard Button ")
                    M3OutlinedButton(onClick = { /*TODO*/ }, text = "Outlined Button")



                    M3Button(
                        onClick = { /*TODO*/ },
                        text = "Standard Button",
                        emphasisLevel = EmphasisLevel.HighEmphasis
                    )
                    M3Button(
                        onClick = { /*TODO*/ },
                        text = "Standard Button",
                        emphasisLevel = EmphasisLevel.Destructive
                    )
                    M3Button(
                        onClick = { /*TODO*/ },
                        text = "Standard Full Width Button", fullWidth = true,
                        emphasisLevel = EmphasisLevel.HighEmphasis
                    )

                    M3ButtonWithIcon(
                        onClick = { /*TODO*/ },
                        iconPlacing = IconPlacing.Trailing,
                        text = "ON"
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_arrow_drop_down_24),
                            contentDescription = "text"
                        )
                    }

                    M3ButtonWithIcon(
                        onClick = { /*TODO*/ },
                        iconPlacing = IconPlacing.Leading,
                        text = "OFF"
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_down_24),
                            contentDescription = "text"
                        )
                    }
                    M3TextButton(onClick = { /*TODO*/ }, text = "Text Button")


                }


            }
        }
    }
}

@Composable
fun NewButton() {

}


