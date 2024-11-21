package cc.aa64.saigo.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun PianoOctaveLayout(modifier: Modifier = Modifier, octave: Int) {
    Row(modifier = modifier) {
        Box {
            Row {
                PianoKey("C", false, octave)
                PianoKey("D", false, octave)
                PianoKey("E", false, octave)
            }
            Row(modifier = Modifier.padding(start = 16.dp)) {
                PianoKey("C#", false, octave)
                Spacer(Modifier.size(16.dp))
                PianoKey("D#", false, octave)
            }
        }
        Box {
            Row {
                PianoKey("F", false, octave)
                PianoKey("G", false, octave)
                PianoKey("A", false, octave)
                PianoKey("B", false, octave)
            }
            Row(modifier = Modifier.padding(start = 16.dp)) {
                PianoKey("F#", false, octave)
                Spacer(Modifier.size(14.dp))
                PianoKey("G#", false, octave)
                Spacer(Modifier.size(14.dp))
                PianoKey("A#", false, octave)
            }
        }
    }
}

@Composable
fun PianoKey(note: String, root: Boolean = false, octave: Int) {
    val isBlackKey = note.endsWith("#")

    val blackModifier = remember { Modifier.border(1.dp, Color.LightGray).width(12.dp).height(64.dp) }
    val whiteModifier = remember { Modifier.border(1.dp, Color.LightGray).width(24.dp).height(82.dp) }

    Button(
        modifier = (if (isBlackKey) blackModifier else whiteModifier).testTag(note),
        colors = ButtonDefaults.buttonColors(backgroundColor = if (isBlackKey) Color.Black else Color.White),
        onClick = {
            println("Pressed: $note")
            playNote(note, octave)
        },
    ) {
        if (root) Text("C")
    }
}



@Composable
fun PianoBlackKey(note: String, modifier: Modifier = Modifier) {
    Button(
        modifier = modifier.testTag(note),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
        onClick = { println("Pressed: $note") },
    ) {}
}