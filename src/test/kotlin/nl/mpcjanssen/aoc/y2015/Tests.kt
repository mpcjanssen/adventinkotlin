package nl.mpcjanssen.aoc.y2015

import org.junit.Assert.assertEquals
import org.junit.Test

class Tests {
    @Test
    fun day01test() {
        val expected = Pair(232,1783)
        assertEquals(expected, day01().results())
    }
    @Test
    fun day02test() {
        val expected = Pair(1586300,3737498)
        assertEquals(expected, day02().results())
    }

    @Test
    fun day03test() {
        val expected = Pair(2565,2639)
        assertEquals(expected, day03().results())
    }
    @Test
    fun day04test() {
        val expected = Pair(346386,9958218)
        assertEquals(expected, day04().results())
    }

    @Test
    fun day05test() {
        val expected = Pair(236,51)
        assertEquals(expected, day05().results())
    }

    @Test
    fun day06test() {
        val expected = Pair(377891,14110788)
        assertEquals(expected, day06().results())
    }

    @Test
    fun day07test() {
        val expected = Pair(-1,-1)
        assertEquals(expected, day07().results())
    }

    //@Test
    fun dayXtest() {
        val expected = Pair(-1,-1)
        assertEquals(expected, dayx().results())
    }
}