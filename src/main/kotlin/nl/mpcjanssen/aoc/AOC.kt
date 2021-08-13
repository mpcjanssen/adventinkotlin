package nl.mpcjanssen.aoc

import java.math.BigInteger
import java.security.MessageDigest

class Day<T>(year: Int, day: Int,
    val part1: ((input: T) -> Int),
    val part2: ((input: T) -> Int),
    val transform: ((String) -> T))   {
    val rawInput: String =   this.javaClass.getResource( "/input/%d-%02d.txt".format(year,day)).readText()
    fun results() : Pair<Int,Int> {
        return Pair(part1.invoke(input) , part2.invoke(input)  )
    }
    private val input  = transform.invoke(rawInput)
}

fun Pair<Int,Int>.arrowDirection(c: Char) : Pair<Int,Int> {
    val (x,y) = this
    return when(c) {
        '^' -> x to y - 1
        'v' -> x to y + 1
        '<' -> x + 1 to y
        '>' -> x - 1 to y
        else -> throw java.lang.Exception("Invalid direction $c")
    }
}

fun String.md5(): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(this.toByteArray())).toString(16).padStart(32, '0')
}