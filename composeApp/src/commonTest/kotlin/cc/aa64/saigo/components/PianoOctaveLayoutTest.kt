package cc.aa64.saigo.components

import androidx.compose.foundation.layout.Box
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.runComposeUiTest
import org.junit.Test

@OptIn(ExperimentalTestApi::class)
class PianoOctaveLayoutTest {
    @Test
    fun renders() = runComposeUiTest {
        setContent { PianoOctaveLayout() }

        onNodeWithTag("C").assertExists().assertIsDisplayed()
        onNodeWithTag("C#").assertExists().assertIsDisplayed()
        onNodeWithTag("D").assertExists().assertIsDisplayed()
        onNodeWithTag("D#").assertExists().assertIsDisplayed()
        onNodeWithTag("E").assertExists().assertIsDisplayed()
        onNodeWithTag("F").assertExists().assertIsDisplayed()
        onNodeWithTag("F#").assertExists().assertIsDisplayed()
        onNodeWithTag("G").assertExists().assertIsDisplayed()
        onNodeWithTag("G#").assertExists().assertIsDisplayed()
        onNodeWithTag("A").assertExists().assertIsDisplayed()
        onNodeWithTag("A#").assertExists().assertIsDisplayed()
        onNodeWithTag("B").assertExists().assertIsDisplayed()
    }
}