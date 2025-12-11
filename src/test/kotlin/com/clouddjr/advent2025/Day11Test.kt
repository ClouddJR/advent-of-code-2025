package com.clouddjr.advent2025

import com.clouddjr.advent2025.Resources.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 11")
class Day11Test {
    private val inputPart1 = """
        aaa: you hhh
        you: bbb ccc
        bbb: ddd eee
        ccc: ddd eee fff
        ddd: ggg
        eee: out
        fff: out
        ggg: out
        hhh: ccc fff iii
        iii: out
    """.trimIndent().lines()

    private val inputPart2 = """
        svr: aaa bbb
        aaa: fft
        fft: ccc
        bbb: tty
        tty: ccc
        ccc: ddd eee
        ddd: hub
        hub: fff
        eee: dac
        dac: fff
        fff: ggg hhh
        ggg: out
        hhh: out
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day11(inputPart1).solvePart1()

            assertEquals(5, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day11(resourceAsListOfString("day11.txt")).solvePart1()

            assertEquals(658, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day11(inputPart2).solvePart2()

            assertEquals(2, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day11(resourceAsListOfString("day11.txt")).solvePart2()

            assertEquals(371_113_003_846_800, answer)
        }
    }
}
