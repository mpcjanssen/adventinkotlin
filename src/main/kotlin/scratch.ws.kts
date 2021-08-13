@file:Suppress("unused")

import nl.mpcjanssen.aoc.md5
import nl.mpcjanssen.aoc.y2015.day03
import nl.mpcjanssen.aoc.y2015.day04
import nl.mpcjanssen.aoc.y2015.day05
import nl.mpcjanssen.aoc.y2015.day06

import java.lang.Exception
import java.lang.RuntimeException
val lights = mutableSetOf<Pair<Int,Int>>()
day06().rawInput.lines().forEach { line ->
    val m = "(turn off|turn on|toggle) ([0-9]+,[0-9]+) through ([0-9]+,[0-9]+)".toRegex().matchEntire(line)
    val cmd = m?.groupValues?.get(1)?:""
    val (x1,y1) = m?.groupValues?.get(2)?.split(",")?.map { it.toInt() }!!
    val (x2,y2) = m?.groupValues?.get(3)?.split(",")?.map { it.toInt() }!!
    for (x in x1..x2) {
        for (y in y1..y2) {
            val p = Pair(x,y)
            when (cmd) {
                "turn on" -> {lights.add(p)}
                "turn off" -> {lights.remove(p)}
                "toggle" -> {
                    if (lights.contains(p))  lights.remove(p) else lights.add(p)
                }
                else -> {throw RuntimeException("Can't parse ${line}")}
            }
        }
    }
}
lights.count()