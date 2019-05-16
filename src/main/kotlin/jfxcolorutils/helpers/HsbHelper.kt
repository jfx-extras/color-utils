package jfxcolorutils.helpers

import jfxcolorutils.HSB
import kotlin.math.roundToInt


internal fun htmlToHsb(htmlColor: String): HSB {
    throw NotImplementedError()
}

internal fun hexToHsb(hexColor: String): HSB {
    throw NotImplementedError()
}

internal fun rgbToHsb(rgbColor: String): HSB {
    val color = rgbColor
        .replace("(", "")
        .replace(")", "")
        .replace(" ", "")
    val colorArray = color.split(",")

    val r: Double = colorArray[0].toDouble() / 255
    val g: Double = colorArray[1].toDouble() / 255
    val b: Double = colorArray[2].toDouble() / 255

    val cMax: Double = maxOf(r, g, b)
    val cMin: Double = minOf(r, g, b)
    val delta: Double = cMax - cMin

    val h: Double = calculateH(r, g, b, delta)
    val s: Double = if (cMax < 0.00001) 0.0 else delta / cMax

    return HSB(
        h.roundToInt(),
        (s * 100).roundToInt(),
        (cMax * 100).roundToInt()
    )
}

internal fun rgbaToHsb(rgbaColor: String): HSB {
    throw NotImplementedError()
}

internal fun hsvToHsb(hsvColor: String): HSB {
    val color = hsvColor
        .replace("(", "")
        .replace(")", "")
        .replace(" ", "")
        .replace("%", "")
        .replace("°", "")
    val colorArray = color.split(",")
    return HSB(
        colorArray[0].toInt(),
        colorArray[1].toInt(),
        colorArray[2].toInt()
    )
}

internal fun hslToHsb(hslColor: String): HSB {
    throw NotImplementedError()
}

internal fun hsbToHsb(hsbColor: String): HSB {
    val color = hsbColor
        .replace("(", "")
        .replace(")", "")
        .replace(" ", "")
        .replace("%", "")
        .replace("°", "")
    val colorArray = color.split(",")
    return HSB(
        colorArray[0].toInt(),
        colorArray[1].toInt(),
        colorArray[2].toInt()
    )
}