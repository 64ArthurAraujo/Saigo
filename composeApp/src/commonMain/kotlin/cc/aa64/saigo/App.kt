package cc.aa64.saigo


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cc.aa64.saigo.components.PianoKey
import cc.aa64.saigo.components.PianoOctaveLayout
import cc.aa64.saigo.components.Synthesizer
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        LaunchedEffect(Unit) {
            Synthesizer.open()
        }

        Box(Modifier.fillMaxSize().background(MaterialTheme.colors.onBackground)) {
            Row(Modifier.align(Alignment.Center)) {
                for (i in 2..6) {
                    Row(Modifier.border(0.5.dp, Color.LightGray)) {
                        Box {
                            Row {
                                PianoWhiteTimelineKey()
                                PianoWhiteTimelineKey()
                                PianoWhiteTimelineKey()
                            }
                            Row(modifier = Modifier.padding(start = 16.dp)) {
                                PianoBlackTimelineKey()
                                Spacer(Modifier.size(16.dp))
                                PianoBlackTimelineKey()
                            }
                        }
                        Box {
                            Row {
                                PianoWhiteTimelineKey()
                                PianoWhiteTimelineKey()
                                PianoWhiteTimelineKey()
                                PianoWhiteTimelineKey()
                            }
                            Row(modifier = Modifier.padding(start = 16.dp)) {
                                PianoBlackTimelineKey()
                                Spacer(Modifier.size(14.dp))
                                PianoBlackTimelineKey()
                                Spacer(Modifier.size(14.dp))
                                PianoBlackTimelineKey()
                            }
                        }
                    }
                }
            }
            Row(Modifier.align(Alignment.BottomCenter)) {
                for (i in 2..6) {
                    PianoOctaveLayout(octave = i)
                }
            }
        }
    }
}

@Composable
fun PianoWhiteTimelineKey(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.background(Color.Gray).width(24.dp).fillMaxHeight(),
    ) {}
}

@Composable
fun PianoBlackTimelineKey(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.background(Color.Gray).width(12.dp).fillMaxHeight(),
    ) {}
}