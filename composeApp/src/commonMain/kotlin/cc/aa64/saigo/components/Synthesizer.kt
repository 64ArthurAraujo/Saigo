package cc.aa64.saigo.components

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Thread.sleep
import javax.sound.midi.MidiSystem
import javax.sound.midi.Synthesizer

object Synthesizer {
    private val synthesizer: Synthesizer = MidiSystem.getSynthesizer()

    fun open() {
        if (!synthesizer.isOpen) synthesizer.open()

        val instruments = synthesizer.defaultSoundbank?.instruments
        val pianoInstrument = instruments?.firstOrNull { it.name.contains("Piano", ignoreCase = true) }

        val channel = synthesizer.channels[0] // Choose channel 0

        pianoInstrument?.let {
            synthesizer.loadInstrument(it)
            channel.programChange(it.patch.bank, it.patch.program)
        } ?: println("Piano instrument not found; using default instrument.")
    }

    fun playNote(midiNote: Int, velocity: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val channel = synthesizer.channels[0] // Choose channel 0
            channel.noteOn(midiNote, velocity)

            sleep(1000)

            channel.noteOff(midiNote)
        }
    }
}
