package org.example

import java.io.File
import java.math.BigDecimal
import java.math.BigInteger
import java.math.MathContext
import java.math.RoundingMode

fun main() {
    val input = File("input.txt").readLines()
    val headerSplitRegex = """: +""".toRegex()
    val time = input[0].split(headerSplitRegex)[1].split(""" +""".toRegex()).joinToString(separator = "").toBigInteger()
    val distance =
        input[1].split(headerSplitRegex)[1].split(""" +""".toRegex()).joinToString(separator = "").toBigInteger()

    val delta = (time * time - BigInteger("4") * distance).toBigDecimal()
    val timeMin = (time.toBigDecimal() - delta.sqrt(MathContext.DECIMAL128)) / BigDecimal(2)
    val timeMax = (time.toBigDecimal() + delta.sqrt(MathContext.DECIMAL128)) / BigDecimal(2)
    val timeMaxFloor = timeMax.setScale(0, RoundingMode.FLOOR).unscaledValue()
    val timeMinCeiling = timeMin.setScale(0, RoundingMode.CEILING).unscaledValue()
    (timeMaxFloor - timeMinCeiling + BigInteger("1")).also(::println)
}
