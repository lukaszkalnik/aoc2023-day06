package org.example

import java.io.File
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.sqrt

fun main() {
    val input = File("input.txt").readLines()
    val headerSplitRegex = """: +""".toRegex()
    val times = input[0].split(headerSplitRegex)[1].split(""" +""".toRegex()).map { it.toInt() }
    val distances = input[1].split(headerSplitRegex)[1].split(""" +""".toRegex()).map { it.toInt() }

    times.zip(distances).map { (time, distance) ->
        val delta = time * time - 4 * distance
        val timeMin = (time - sqrt(delta.toFloat())) / 2
        val timeMax = (time + sqrt(delta.toFloat())) / 2

        val minWinningTime = if (timeMin == ceil(timeMin)) timeMin + 1 else ceil(timeMin)
        val maxWinningTime = if (timeMax == floor(timeMax)) timeMax - 1 else floor(timeMax)

        (maxWinningTime - minWinningTime + 1).toInt()
    }.reduce(Int::times)
        .also(::println)
        .also { check(it == 2612736) }
}
