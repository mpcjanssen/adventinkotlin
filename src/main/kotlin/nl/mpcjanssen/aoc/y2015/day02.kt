package nl.mpcjanssen.aoc.y2015

import nl.mpcjanssen.aoc.Day


fun day02()  = Day(2015,2,
    transform = {
        it.lines().map {
            line -> line.split("x").map { part -> part.toInt()}
        }
    },
    part1 = { input ->
        input.sumOf { dims ->
            val (x, y, z) = dims.sorted()
            2 * x * y + 2 * y * z + 2 * z * x + x * y
        }
    },
    part2 = { input ->
        input.sumOf { dims ->
            val (x, y, z) = dims.sorted()
            2 * x + 2 * y + x * y * z
        }
    })
