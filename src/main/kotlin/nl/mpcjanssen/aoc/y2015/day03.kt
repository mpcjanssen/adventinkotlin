package nl.mpcjanssen.aoc.y2015

import nl.mpcjanssen.aoc.Day
import nl.mpcjanssen.aoc.arrowDirection

fun day03()  = Day(2015,3,
    transform = {it},
    part1 = { input ->
        val santaPath = mutableListOf(0 to 0)
        input.forEach {
                c ->
            santaPath.add(santaPath.last().arrowDirection(c))
        }
        santaPath.distinct().size
    },
    part2 =  { input ->
        val santaPath = mutableListOf(0 to 0)
        val roboPath = mutableListOf(0 to 0)

        input.chunked(2).forEach { c ->
            santaPath.add(santaPath.last().arrowDirection(c[0]))
            roboPath.add(roboPath.last().arrowDirection(c[1]))
        }
        santaPath.addAll(roboPath)
        santaPath.distinct().size
    })