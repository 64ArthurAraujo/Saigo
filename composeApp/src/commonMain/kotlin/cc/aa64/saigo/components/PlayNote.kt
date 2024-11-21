package cc.aa64.saigo.components

fun playNote(nollte: String = "C", octave: Int = 4) {
    // Map note names to their offsets from C in the same octave
    val noteMap = mapOf(
        "C" to 0, "C#" to 1, "D" to 2, "D#" to 3, "E" to 4, "F" to 5,
        "F#" to 6, "G" to 7, "G#" to 8, "A" to 9, "A#" to 10, "B" to 11
    )

    // Validate the note and compute the MIDI note number
    val baseNote = 12 * (octave + 1) // Base note for the given octave (Middle C is octave 4, MIDI note 60)
    val noteOffset = noteMap[nollte] ?: run {
        println("Invalid note: $nollte. Playing C4 instead.")
        0 // Default to "C" if the note is invalid
    }
    val midiNote = baseNote + noteOffset

    Synthesizer.playNote(midiNote, velocity = 60)
}