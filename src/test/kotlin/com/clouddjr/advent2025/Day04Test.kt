package com.clouddjr.advent2025

import com.clouddjr.advent2025.Resources.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 4")
class Day04Test {
    private val input = """
        ..@@.@@@@.
        @@@.@.@.@@
        @@@@@.@.@@
        @.@@@@..@.
        @@.@@@@.@@
        .@@@@@@@.@
        .@.@.@.@@@
        @.@@@.@@@@
        .@@@@@@@@.
        @.@.@@@.@.
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day04(input).solvePart1()

            assertEquals(13, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day04(resourceAsListOfString("day04.txt")).solvePart1()

            assertEquals(1344, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day04(input).solvePart2()

            assertEquals(43, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day04(resourceAsListOfString("day04.txt")).solvePart2()

            assertEquals(8112, answer)
        }
    }
}
