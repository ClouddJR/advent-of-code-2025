package com.clouddjr.advent2025

import com.clouddjr.advent2025.Resources.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 3")
class Day03Test {
    private val input = """
        987654321111111
        811111111111119
        234234234234278
        818181911112111
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day03(input).solvePart1()

            assertEquals(357, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day03(resourceAsListOfString("day03.txt")).solvePart1()

            assertEquals(17_359, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day03(input).solvePart2()

            assertEquals(3_121_910_778_619, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day03(resourceAsListOfString("day03.txt")).solvePart2()

            assertEquals(172_787_336_861_064, answer)
        }
    }
}
