package nl.mpcjanssen.aoc.y2015

import nl.mpcjanssen.aoc.Day

fun nice1(str: String) : Boolean {
    return "[aeiou]".toRegex().findAll(str).count() > 2 &&
    "([a-z])\\1".toRegex().containsMatchIn(str) &&
    !"(ab|cd|pq|xy)".toRegex().containsMatchIn(str)
}

fun nice2(str: String) : Boolean {
    return "(..).*\\1".toRegex().containsMatchIn(str) &&
            "(.).\\1".toRegex().containsMatchIn(str)
}

fun day05()  = Day(2015,5,
    transform = {it.lines()},
    part1 = { input ->
        input.count { nice1(it) }
    },
    part2 =  { input ->
        input.count { nice2(it) }
    })