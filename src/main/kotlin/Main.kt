package org.example

import java.io.File
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.sqrt

fun main() {
    val input = File("input.txt").readLines()
    val headerSplitRegex = """: +""".toRegex()
    val time = input[0].split(headerSplitRegex)[1].filter(Char::isDigit).toLong()
    val distance = input[1].split(headerSplitRegex)[1].filter(Char::isDigit).toLong()

    val delta = (time * time - 4 * distance).toDouble()
    val timeMin = (time - sqrt(delta)) / 2
    val timeMax = (time + sqrt(delta)) / 2
    val maxWinningTime = if (timeMax == floor(timeMax)) (timeMax - 1) else floor(timeMax)
    val minWinningTime = if (timeMin == ceil(timeMin)) timeMin + 1 else ceil(timeMin)
    (maxWinningTime - minWinningTime + 1).toInt().also(::println)
        .also { check(it == 29891250) }
}
