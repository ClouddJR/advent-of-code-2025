package com.clouddjr.advent2025

import com.clouddjr.advent2025.Resources.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 9")
class Day09Test {
    private val input = """
        7,1
        11,1
        11,7
        9,7
        9,5
        2,5
        2,3
        7,3
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day09(input).solvePart1()

            assertEquals(50, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day09(resourceAsListOfString("day09.txt")).solvePart1()

            assertEquals(4_735_268_538, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day09(input).solvePart2()

            assertEquals(24, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day09(resourceAsListOfString("day09.txt")).solvePart2()

            assertEquals(1_537_458_069, answer)
        }
    }
}
