package nl.mpcjanssen.aoc.y2015

import nl.mpcjanssen.aoc.Day
import java.lang.Integer.max
import java.lang.RuntimeException

fun day06()  = Day(2015,6,
    transform = {it.lines()},
    part1 = { input ->
        val lights = mutableSetOf<Pair<Int,Int>>()
        input.forEach { line ->
            val m = "(turn off|turn on|toggle) ([0-9]+,[0-9]+) through ([0-9]+,[0-9]+)".toRegex().matchEntire(line)
            val cmd = m?.groupValues?.get(1) ?: ""
            val (x1, y1) = m?.groupValues?.get(2)?.split(",")?.map { it.toInt() }!!
            val (x2, y2) = m?.groupValues?.get(3)?.split(",")?.map { it.toInt() }!!
            for (x in x1..x2) {
                for (y in y1..y2) {
                    val p = Pair(x, y)
                    when (cmd) {
                        "turn on" -> {
                            lights.add(p)
                        }
                        "turn off" -> {
                            lights.remove(p)
                        }
                        "toggle" -> {
                            if (lights.contains(p)) lights.remove(p) else lights.add(p)
                        }
                        else -> {
                            throw RuntimeException("Can't parse ${line}")
                        }
                    }
                }
            }
        }
        lights.size
    },
    part2 =  { input ->
        val lights = mutableMapOf<Pair<Int,Int>,Int>()
        input.forEach { line ->
            val m = "(turn off|turn on|toggle) ([0-9]+,[0-9]+) through ([0-9]+,[0-9]+)".toRegex().matchEntire(line)
            val cmd = m?.groupValues?.get(1) ?: ""
            val (x1, y1) = m?.groupValues?.get(2)?.split(",")?.map { it.toInt() }!!
            val (x2, y2) = m?.groupValues?.get(3)?.split(",")?.map { it.toInt() }!!
            for (x in x1..x2) {
                for (y in y1..y2) {
                    val p = Pair(x, y)
                    val curr = lights.getOrDefault(p,0)
                    when (cmd) {
                        "turn on" -> {
                            lights[p] = curr + 1
                        }
                        "turn off" -> {
                            lights[p] = max(curr - 1,0)
                        }
                        "toggle" -> {
                            lights[p] = curr + 2
                        }
                        else -> {
                            throw RuntimeException("Can't parse ${line}")
                        }
                    }
                }
            }
        }
        lights.values.sum()
    })