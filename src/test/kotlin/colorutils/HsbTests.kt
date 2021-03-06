package colorutils

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

internal class HsbTests {
    private val hexColor: String = "#0078D7"
    private val rgbColor: String = "rgb(0, 118, 214)"
    private val hsbColor: String = "hsb(207, 100%, 84%)"
    private val hsbColorDegree: String = "hsb(207°, 100%, 84%)"

    @Test
    fun convertHexToHsb() {
        val elapsed = measureTimeMillis {
            toHsb(hexColor).toString()
        }
        println("convertHexToHsb: Done with $elapsed ms.")

        Assertions.assertEquals(
            "hsb(207, 100%, 84%)",
            toHsb(hexColor).toString()
        )
    }

    @Test
    fun convertRgbToHsb() {
        Assertions.assertEquals(
            hsbColor,
            toHsb(rgbColor).toString()
        )
    }

    @Test
    fun convertHsbToHsb() {
        Assertions.assertEquals(
            hsbColor,
            toHsb(hsbColor).toString()
        )
    }

    @Test
    fun convertHsvToHsb() {
        Assertions.assertEquals(
            "hsb(27, 84%, 100%)",
            toHsb("hsv(27, 84%, 100%)").toString()
        )
    }

    @Test
    fun convertHsvToHsbWithDegree() {
        Assertions.assertEquals(
            "hsb(27°, 84%, 100%)",
            toHsb("hsv(27°, 84%, 100%)").toString(true)
        )
    }

    @Test
    fun convertRgbToHsbWithDegree() {
        Assertions.assertEquals(
            hsbColorDegree,
            toHsb(rgbColor).toString(true)
        )
    }

    @Test
    fun equalsHsvClasses() {
        Assertions.assertEquals(
            HSB(207, 100, 84),
            HSB(207, 100, 84)
        )
    }

    @Test
    fun hashCodeEqualsHsvClasses() {
        Assertions.assertEquals(
            HSB(207, 100, 84).hashCode(),
            HSB(207, 100, 84).hashCode()
        )
    }

    @Test
    fun invalidColor() {
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
            toHsb("hwb(0, 17, 83)")
        }
        Assertions.assertEquals("Not supported color specification.", exception.message)
    }
}
