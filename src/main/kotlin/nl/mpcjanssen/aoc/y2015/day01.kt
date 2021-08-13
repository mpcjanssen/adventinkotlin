package nl.mpcjanssen.aoc.y2015

import nl.mpcjanssen.aoc.Day


fun day01()  = Day(2015,1,
    transform =  {it},
    part1 = { input ->
        input.fold(0) { acc, c ->
            if (c == '(') acc + 1 else acc - 1
        }
    },
    part2 =  { input ->
        input.foldIndexed(0) {
                idx, acc, c ->
            if (acc < 0) return@Day idx
            if (c == ('(')) acc+1 else acc-1
        }
    })



