package nl.mpcjanssen.aoc.y2015

import nl.mpcjanssen.aoc.Day
import nl.mpcjanssen.aoc.md5

fun day04()  = Day(2015,4,
    transform = {it},
    part1 = { input ->
        var tail = 0
        while (true) {
            val next = "$input$tail".md5()
            if (next.startsWith("00000")) {
                break
            }
            tail++
        }
        tail
    },
    part2 = { input ->
        var tail = 0
        while (true) {
            val next = "$input$tail".md5()
            if (next.startsWith("000000")) {
                break
            }
            tail++
        }
        tail
    },)